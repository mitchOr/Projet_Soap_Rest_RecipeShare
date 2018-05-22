package com.Controller;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import com.Entites.Recipe;
import com.Entites.User;
import com.Model.ModelRecipe;
import com.swing.graphique.Accueil;
import com.swing.graphique.Connexion;
import com.swing.graphique.ProfilFrame;

public class AccueilController extends GeneralController {
	private Accueil AccueilView;
	private JTable table;
	private ModelRecipe model;
	
	public AccueilController(Accueil AccueilView)
	{
		super();
		this.setAccueilView(AccueilView);				
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

	/**
	 * initialize the model
	 */
	public void init()
	{
		
		model=new ModelRecipe();	
		model.clear();
		fillModel();
		
	}
	
	/**
	 * 
	 * @return scrollPane to print in the jtable
	 */
	public void updateJTable()
	{
		//initialize the model before adding it to the table
		init();
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
	public void removeRecipeInOut(int rowIndex)
	{
		model.removeData(rowIndex);
	}
	/**
	 * fill the model with the historical in company
	 */
	
	 public void fillModel()
	{
		 Recipe[] list = null;
		try {
			list = RecipeProxy.getRecipes();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Recipe entry : list) {
		   
		    	model.addRecipe(entry);
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

	public Accueil getAccueilView() {
		return AccueilView;
	}

	public void setAccueilView(Accueil accueilView) {
		AccueilView = accueilView;
	}
	

	
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
		profil.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		profil.setVisible(true);
		AccueilView.update();
		
	}
	
	
	/**
	 * gère le double clique 
	 * @param e
	 */
          public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 2) {
              Point p = e.getPoint();
   
              	int i = table.getSelectedRow();
				String s = model.getValueAt(i, 0).toString();
				int ID = Integer.parseInt(s);
				printRecipe(ID);
				
              }
            }

	public void deconnection() {
		Connexion frame = new Connexion();
		AccueilView.dispose();
		frame.setVisible(true);
		
	}

	
	      

}
