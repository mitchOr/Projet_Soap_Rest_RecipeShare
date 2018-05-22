package com.Controller;

import java.text.*;
import java.util.Date;

import javax.swing.JOptionPane;

import com.model.*;
import com.swing.graphique.CreateRecipeFrame;

/**
 * 
 * Controller for creating recipe
 *
 */
public class CreateRecipeFrameController extends GeneralController {

	CreateRecipeFrame myFrame;

	/**
	 * Constructor
	 * 
	 * @param frame
	 */
	public CreateRecipeFrameController(CreateRecipeFrame frame) {
		this.myFrame = frame;

	}

	/**
	 * save the Recipe in the database
	 * 
	 * @param user
	 * @param bodyRecipe
	 */
	public void post(User user, String bodyRecipe) {
		// define the format to put in the database
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dat = dateFormat.format(actuelle);

		if (rService.testAddRecipe(bodyRecipe, dat, user.getId()).equals("pass")) {
			// JOptionPane jop3 = new JOptionPane();
			JOptionPane.showMessageDialog(null, "Adding Recipe succes!!!!!!", "Information",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			// JOptionPane jop3 = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Oups a problem occured Adding Recipe fail!!!!!!", "Information",
					JOptionPane.INFORMATION_MESSAGE);

		}
		this.myFrame.dispose();
	}
}
