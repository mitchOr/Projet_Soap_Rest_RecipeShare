package com.Controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import com.Entites.Recipe;
import com.Entites.User;
import com.Model.ModelRecipe;
import com.Services.RecipeServicesProxy;
import com.swing.graphique.Accueil;
import com.swing.graphique.CreateRecipeFrame;
import com.swing.graphique.DisplayRecipeFrame;
import com.swing.graphique.ProfilFrame;

public class ProfilController extends GeneralController{
	private ProfilFrame profil;
	private JTable table;
	private ModelRecipe model;
	private  int id;

	/**
	 * constructor
	 */
	public ProfilController( ProfilFrame frame , int UserId) {
				super();
				id = UserId;
		this.profil=frame;
		}

	
	/**
	 * 
	 * @return scrollPane to print in the jtable
	 */
	public void updateJTable()
	{
		//initialize the model before adding it to the table
		
		model=new ModelRecipe();	
		model.clear();
		fillModel(id);
		this.table=new JTable(this.model);
		model.update();
	}
	

	/**
	 * 
	 * @param data to add
	 */
	public void addRecipeInOut(Recipe data)
	{
		model.addRecipe(data);
		
	}
	
	/**
	 * 
	 * @param rowIndex row of data to remove
	 */
	public void removeRecipe(int rowIndex)
	{
		model.removeData(rowIndex);
	}
	/**
	 * fill the model with the historical in company
	 */
	 public void fillModel(int id)
	{
		 Recipe[] list = null;
		try {
			list = RecipeProxy.getRecipes();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Recipe entry : list) {

			if(entry.getAuthor()==id)
			{
		    	model.addRecipe(entry);
			}
		}
		
	}
	
	/**
	 * eanables to show in the jtable only rows containing query
	 * @param query tne string to filter
	 */
	public void filter(String query)
	{	
		TableRowSorter<ModelRecipe> tr = new TableRowSorter<ModelRecipe>(model);
		table.setRowSorter(tr);
		
		if(query!="All")
		{
			tr.setRowFilter(RowFilter.regexFilter(query));
			
		}else 
		{
			table.setRowSorter(tr);
		}
		
	}
	

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}



	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	
	/**
	 * print Recipe and his author
	 * @param id
	 */
	public void printRecipe(int id)
	{
		Recipe reci=null;
		User u=null;
		try {
			 reci= RecipeProxy.getRecipeByID(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 u=userProxy.getUser(reci.getAuthor()) ;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DisplayRecipeFrame frame= new DisplayRecipeFrame();
		frame.setRecipeField(u.getFirstName()+" "+u.getLastName(), reci.getCreationDate(), reci.getText());
		frame.setVisible(true);
	} 
	
	/**
	 * open the frame profil for the connected user
	 * @param id
	 */
	public void profilLook(int id)
	{
		User user=null;
		try {
			user = userProxy.getUser(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProfilFrame profil= new ProfilFrame(user);
		profil.setVisible(true);
	}

	/**
	 * get id
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * add id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * create a frame for adding a recipe
	 * @param user
	 */
	public void createRecipe(User user)
	{
		CreateRecipeFrame frame= new CreateRecipeFrame(user);
		frame.setVisible(true);
		profil.update();
		
	}
	
	/**
	 * delete the selectionned data
	 */
	public void deletRecipe()
	{
		int i = table.getSelectedRow();
		String s = model.getValueAt(i, 0).toString();
		int idselected = Integer.parseInt(s);
		try {
			if (RecipeProxy.deleteRecipe(idselected).equals("success"))
			{
				JOptionPane jop3 = new JOptionPane();
				jop3.showMessageDialog(null, "Deleting Recipe succes!!!!!!", "Information",JOptionPane.INFORMATION_MESSAGE);
					
			}
			else
			{
				JOptionPane jop3 = new JOptionPane();
				jop3.showMessageDialog(null, " Oups a problem occured while deleting Recipe!!!!!!", "Information",JOptionPane.INFORMATION_MESSAGE);				
			}
			profil.update();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * edit a recipe
	 * @param user
	 */
	public void editRecipe(User user)
	{
		RecipeServicesProxy recipProxy = new RecipeServicesProxy();
		int i = table.getSelectedRow();
		String s = model.getValueAt(i, 0).toString();
		String bodyRecipe = model.getValueAt(i, 1).toString();
		CreateRecipeFrame frame= new CreateRecipeFrame(user);
		frame.setBody(bodyRecipe);
		frame.setVisible(true);
		try {
			recipProxy.deleteRecipe(Integer.parseInt(s));
			profil.update();
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	/**
	 * @return the model
	 */
	public ModelRecipe getModel() {
		return model;
	}


	/**
	 * @param model the model to set
	 */
	public void setModel(ModelRecipe model) {
		this.model = model;
	}


	public void mousePress(MouseEvent e) {
		if (e.getClickCount() == 2) { 
            	int i = table.getSelectedRow();
				String s = model.getValueAt(i, 0).toString();
				int ID = Integer.parseInt(s);
				printRecipe(ID);
				
            }
		
	}


	

			
		
}
