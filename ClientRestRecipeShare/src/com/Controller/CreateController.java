package com.Controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.model.*;
import com.service.*;
import com.swing.graphique.CreateUser;

/**
 * 
 * Controller for creation
 *
 */
public class CreateController extends GeneralController {

	private CreateUser createUserJframe;

	/**
	 * Constructor
	 * 
	 * @param createUs
	 */
	public CreateController(CreateUser createUs) {
		super();
		createUserJframe = createUs;

	}

	/**
	 * Creating user
	 * 
	 * @param fna
	 * @param lna
	 * @param birth
	 * @param login
	 * @param pass
	 * @param pass2
	 */
	public void createUser(String fna, String lna, String birth, String login, String pass, String pass2) {
		// v�rifie le login
		List<User> listUser = null;
		boolean Problem = false;
		UserService uService = new UserService();
		uService.init();
		listUser = uService.testGetAllUsers();
		// on parcours pour v�rifier que le login n'existe pas
		for (User user : listUser) {
			if (login.equals(user.getLogin())) {
				// JOptionPane jop1 = new JOptionPane();
				JOptionPane.showMessageDialog(null, "The login already exist!! find another one", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				Problem = true;
			}
		}

		// on v�rifie les mots de passe
		if (!pass.equals(pass2)) {
			// JOptionPane jop2 = new JOptionPane();
			JOptionPane.showMessageDialog(null, "the passwords do not match", "Information",
					JOptionPane.INFORMATION_MESSAGE);
			Problem = true;

		}

		if (Problem == false) {
			if (uService.testAddUser(fna, lna, birth, login, pass).equals("pass")) {
				// JOptionPane jop3 = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Adding user succes!!!!!!", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				authentifier(login, pass);
				
				createUserJframe.dispose();
			} else {
				// JOptionPane jop3 = new JOptionPane();
				JOptionPane.showMessageDialog(null, "Adding user fail!!!!!!", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				createUserJframe.dispose();

			}
		}

	}

	/**
	 * close the windows
	 */
	public void close() {
		createUserJframe.dispose();
	}

}
