package com.Controller;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.Entites.User;
import com.swing.graphique.CreateRecipeFrame;

public class CreateRecipeFrameController extends GeneralController {

	CreateRecipeFrame myFrame;
	public CreateRecipeFrameController(CreateRecipeFrame frame) {
		this.myFrame=frame;
	}
	
	/**
	 * save the Recipe in the database
	 * @param user
	 * @param bodyRecipe
	 */
	public void post(User user,String bodyRecipe)
	{
		//define the format to put in the database
		 Date actuelle = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String dat = dateFormat.format(actuelle);
		
		try {
			if (RecipeProxy.createRecipe(bodyRecipe, dat, user.getId()).equals("success"))
			{
				JOptionPane jop3 = new JOptionPane();
				jop3.showMessageDialog(null, "Adding Recipe succes!!!!!!", "Information",JOptionPane.INFORMATION_MESSAGE);
					
			}
			else
			{
				JOptionPane jop3 = new JOptionPane();
				jop3.showMessageDialog(null, " Oups a problem occured Adding Recipe fail!!!!!!", "Information",JOptionPane.INFORMATION_MESSAGE);	
				
			}
			this.myFrame.dispose();	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
