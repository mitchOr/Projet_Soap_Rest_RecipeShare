package com.Controller;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import com.model.*;
import com.swing.graphique.*;

public class ProfilController extends GeneralController {
	private ProfilFrame profil;
	private JTable table;
	private ModelRecipe model;
	private int id;

	/**
	 * constructor
	 */
	public ProfilController(ProfilFrame frame, int UserId) {
		super();
		id = UserId;
		this.profil = frame;

	}

	/**
	 * 
	 * @return scrollPane to print in the jtable
	 */
	public void updateJTable() {
		// initialize the model before adding it to the table

		model = new ModelRecipe();
		model.clear();
		fillModel(id);
		this.table = new JTable(this.model);
		model.update();
	}

	/**
	 * 
	 * @param data
	 *            to add
	 */
	public void addRecipeInOut(Recipe data) {
		model.addRecipe(data);

	}

	/**
	 * 
	 * @param rowIndex
	 *            row of data to remove
	 */
	public void removeRecipe(int rowIndex) {
		model.removeData(rowIndex);
	}

	/**
	 * fill the model with the historical in company
	 */
	public void fillModel(int id) {
		List<Recipe> list = null;
		list = rService.testGetAllRecipes();
		for (Recipe entry : list) {
			if (entry.getAuthor() == id) {
				model.addRecipe(entry);
			}
		}

	}

	/**
	 * eanables to show in the jtable only rows containing query
	 * 
	 * @param query
	 *            tne string to filter
	 */
	public void filter(String query) {
		TableRowSorter<ModelRecipe> tr = new TableRowSorter<ModelRecipe>(model);
		table.setRowSorter(tr);

		if (query != "All") {
			tr.setRowFilter(RowFilter.regexFilter(query));

		} else {
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
	 * @param table
	 *            the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * print Recipe and his author
	 * 
	 * @param id
	 */
	public void printRecipe(int id) {
		Recipe reci = null;
		User u = null;
		reci = rService.testGetRecipe(id);
		u = uService.testGetUser(reci.getAuthor());

		DisplayRecipeFrame frame = new DisplayRecipeFrame();
		frame.setRecipeField(u.getfName() + " " + u.getlName(), reci.getCreationDate(), reci.getText());
		frame.setVisible(true);
	}

	/**
	 * open the frame profil for the connected user
	 * 
	 * @param id
	 */
	public void profilLook(int id) {
		User user = null;
		user = uService.testGetUser(id);
		ProfilFrame profil = new ProfilFrame(user);
		profil.setVisible(true);
	}

	/**
	 * get id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * add id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * create a frame for adding a recipe
	 * 
	 * @param user
	 */
	public void createRecipe(User user) {
		CreateRecipeFrame frame = new CreateRecipeFrame(user);
		frame.setVisible(true);
		profil.update();

	}

	/**
	 * delete the selectionned data
	 */
	public void deletRecipe() {
		int i = table.getSelectedRow();
		String s = model.getValueAt(i, 0).toString();
		int idselected = Integer.parseInt(s);
		if (rService.testDeleteRecipe(idselected).equals("pass")) {
			// JOptionPane jop3 = new JOptionPane();
			JOptionPane.showMessageDialog(null, "Deleting Recipe succes!!!!!!", "Information",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			// JOptionPane jop3 = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Oups a problem occured while deleting Recipe!!!!!!", "Information",
					JOptionPane.INFORMATION_MESSAGE);
		}
		profil.update();
	}

	/**
	 * edit a recipe
	 * 
	 * @param user
	 */
	public void editRecipe(User user) {
		int i = table.getSelectedRow();
		String s = model.getValueAt(i, 0).toString();
		String bodyRecipe = model.getValueAt(i, 1).toString();
		String date = model.getValueAt(i, 2).toString();
		EditRecipeFrame frame = new EditRecipeFrame(Integer.parseInt(s), bodyRecipe, date, user.getId());
		frame.setBody(bodyRecipe);
		frame.setVisible(true);
		profil.update();

	}

	/**
	 * @return the model
	 */
	public ModelRecipe getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(ModelRecipe model) {
		this.model = model;
	}

	/**
	 * 
	 * @param e
	 */
	public void mousePress(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int i = table.getSelectedRow();
			String s = model.getValueAt(i, 0).toString();
			int ID = Integer.parseInt(s);
			printRecipe(ID);

		}
	}

}
