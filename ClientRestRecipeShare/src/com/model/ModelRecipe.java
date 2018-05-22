package com.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.service.UserService;

/**
 * 
 * Class representing a recipe
 *
 */
public class ModelRecipe extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Recipe> historical;
	private final String[] header = { " id ", " body Recipe ", "Creation date", "Authors " };
	private UserService uService;

	/**
	 * Constructor
	 */
	public ModelRecipe() {
		super();
		historical = new ArrayList<Recipe>();
		uService = new UserService();
		uService.init();
	}

	/**
	 * Method to clear the table
	 */
	public void clear() {
		if (historical != null) {
			historical.clear();
		}
	}

	/**
	 * @return the size of historical
	 */
	@Override
	public int getRowCount() {
		return historical.size();
	}

	/**
	 * @return the column's number
	 */
	@Override
	public int getColumnCount() {
		return header.length;
	}

	/**
	 * @param columnIndex
	 * @return the name of the column correponding to param
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return header[columnIndex];
	}

	/**
	 * get value at rowIndex and Columnindex
	 * 
	 * @param rowIndex
	 * @param columnIndex
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return historical.get(rowIndex).getId();
		case 1:
			return historical.get(rowIndex).getText();
		case 2:
			return historical.get(rowIndex).getCreationDate();
		case 3:
			User user;
			user = uService.testGetUser(historical.get(rowIndex).getAuthor());
			return user.getfName() + "  " + user.getlName();
		default:
			return null;
		}
	}

	/**
	 * 
	 * @param datato
	 *            add
	 */
	public void addRecipe(Recipe data) {

		historical.add(data);
		fireTableRowsInserted(historical.size() - 1, historical.size() - 1);

	}

	/**
	 * 
	 * @param rowIndex
	 *            index of data to remove
	 */
	public void removeData(int rowIndex) {
		historical.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	/**
	 * @return the historical
	 */
	public ArrayList<Recipe> getHistorical() {
		return historical;
	}

	/**
	 * @param historical
	 *            the historical to set
	 */
	public void setHistorical(ArrayList<Recipe> historical) {
		this.historical = historical;
		fireTableDataChanged();
	}

	/**
	 * Method to uptable the data
	 */
	public void update() {
		fireTableDataChanged();
	}

}
