package com.Controller;

import javax.swing.JOptionPane;

import com.swing.graphique.*;

/**
 * 
 * Controller for editing recipes
 *
 */
public class EditRecipeFrameController extends GeneralController {
	EditRecipeFrame myFrame;

	/**
	 * Constructor
	 * 
	 * @param frame
	 */
	public EditRecipeFrameController(EditRecipeFrame frame) {
		this.myFrame = frame;

	}

	/**
	 * edit the Recipe in the database
	 * 
	 * @param user
	 * @param bodyRecipe
	 */
	public void edit(int id, String body, String date, int author) {
		if (rService.testUpdateRecipe(id, body, date, author).equals("pass")) {
			// JOptionPane jop3 = new JOptionPane();
			JOptionPane.showMessageDialog(null, "Editing Recipe succes!!!!!!", "Information",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			// JOptionPane jop3 = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Oups a problem occured editing the recipe failed!!!!!!",
					"Information", JOptionPane.INFORMATION_MESSAGE);

		}
		this.myFrame.dispose();
	}

}
