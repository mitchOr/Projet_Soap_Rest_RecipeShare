package com.Controller;

import java.rmi.RemoteException;

import com.Entites.Recipe;
import com.Entites.User;
import com.Services.AuthenticationServiceProxy;
import com.Services.RecipeServicesProxy;
import com.Services.UserServicesProxy;
import com.swing.graphique.Accueil;
import com.swing.graphique.DisplayRecipeFrame;

public  class GeneralController {
	
	protected AuthenticationServiceProxy authentifProxy;
	protected UserServicesProxy userProxy;
	protected RecipeServicesProxy RecipeProxy;
	
	
	/**
	 * 
	 */
	GeneralController()
	{
		 userProxy= new UserServicesProxy();
		 authentifProxy=new AuthenticationServiceProxy();
		 RecipeProxy= new RecipeServicesProxy();
		 
	}
	
	/**
	 * verifie si l'utilisateur existe
	 * @param login
	 * @param password
	 */
	public void authentifier(String login, String password)
	{
	
		try {
			
				if(authentifProxy.connectionUser(login, password))
				{
					
					Accueil window = new Accueil();
					User user= userProxy.getUserbyLogPass(login, password);
					window.setUserName(user.getFirstName(), user.getLastName(),user.getId());
					window.setVisible(true);
				
				}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
