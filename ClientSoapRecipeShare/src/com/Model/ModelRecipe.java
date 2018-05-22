package com.Model;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.Entites.Recipe;
import com.Entites.User;
import com.Services.UserServicesProxy;

public class ModelRecipe extends AbstractTableModel {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Recipe> historical ; 
	private final String[] header = {" id ", " body Recipe ", "Creation date" , "Authors "};
	
	    public ModelRecipe() {
	        super();
	        historical = new ArrayList<Recipe>(); 
	    }
	    
	    public void clear()
	    {
	    	if(historical != null)
	    	{
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
	  * @param rowIndex
	  * @param columnIndex
	  */
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	
	    	UserServicesProxy userProxy = new UserServicesProxy();
	        switch(columnIndex){
	            case 0:
	                return historical.get(rowIndex).getId();
	            case 1:
	                return historical.get(rowIndex).getText();
	            case 2:
	                return historical.get(rowIndex).getCreationDate();
	            case 3:
				User user;
				try {
					user = userProxy.getUser(historical.get(rowIndex).getAuthor());
					 return user.getFirstName()+"  "+user.getLastName();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	               
	            default:
	                return null; 
	        }
	    }
	 
	    /**
	     * 
	     * @param datato add
	     */
	    public void addRecipe(Recipe data) {
	    
	    	 historical.add(data);
	    	 fireTableRowsInserted(historical.size() -1, historical.size() -1);	    	
	       
	    }
	 /**
	  * 
	  * @param rowIndex index of data to remove
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
		 * @param historical the historical to set
		 */
		public void setHistorical(ArrayList<Recipe> historical) {
			this.historical = historical;
			fireTableDataChanged();
		}
		 public void update() {
		        fireTableDataChanged();
		    }

}
