package com.Controller;

import com.swing.graphique.CreateUser;

/**
 * controleur de la jframe connexion
 * 
 * @author mngat
 *
 */
public class ConnexionController extends GeneralController {

	/**
	 * Constructor
	 */
	public ConnexionController() {
		super();
	}

	/**
	 * open the jframe to create an account
	 */
	public void createAccount() {
		CreateUser create = new CreateUser();
		create.run();
	}

}
