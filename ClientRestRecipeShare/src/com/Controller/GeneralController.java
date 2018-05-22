package com.Controller;

import java.util.List;

import com.model.*;
import com.service.*;
import com.swing.graphique.*;

/**
 * 
 * Controller base for all controllers
 *
 */
public class GeneralController {

	protected UserService uService;
	protected RecipeService rService;

	/**
	 * Constructor
	 */
	GeneralController() {

		uService = new UserService();
		uService.init();
		rService = new RecipeService();
		rService.init();
	}

	/**
	 * verifie si l'utilisateur existe
	 * 
	 * @param login
	 * @param password
	 */
	public void authentifier(String login, String password) {

		if (verifCredentials(login, password)) {

			Accueil window = new Accueil();
			User user = getUser(login, password);
			window.setUserName(user.getfName(), user.getlName(), user.getId());
			window.setVisible(true);

		}
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
	 * Verifying credentials
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	public boolean verifCredentials(String login, String password) {

		List<User> users = uService.testGetAllUsers();
		for (User u : users) {

			if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Getting a user from his login or password
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	public User getUser(String login, String password) {

		List<User> users = uService.testGetAllUsers();
		for (User u : users) {
			if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}

}
