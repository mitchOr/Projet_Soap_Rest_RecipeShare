package com.Controller;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.Entites.User;
import com.Services.UserServicesProxy;
import com.swing.graphique.CreateUser;

public class CreateController extends GeneralController {

	private CreateUser createUserJframe;
	
	public CreateController(CreateUser createUs) {
		super();
		createUserJframe=createUs;
	}
	
	public void createUser(String fna, String lna, String birth,String login,String pass,String pass2)
	{
		//vérifie le login
		User[] listUser = null;
		boolean Problem=false;
		try {
			listUser = userProxy.getUsers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//on parcours pour vérifier que le login n'existe pas
		for (User user: listUser )
		{
			if(login.equals(user.getLogin()))
			{
				JOptionPane jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "The login already exist!! find another one", "Information", JOptionPane.INFORMATION_MESSAGE);
				Problem=true;
			}
		}
		
		//on vérifie les mots de passe
		if(!pass.equals(pass2))
		{
			JOptionPane jop2 = new JOptionPane();
			jop2.showMessageDialog(null, "the passwords do not match", "Information", JOptionPane.INFORMATION_MESSAGE);
			Problem=true;

		}
		
		if(Problem==false)
		{
			try {
				if (userProxy.createUser(0, fna, lna, birth, login, pass).equals("success"))
				{
					JOptionPane jop3 = new JOptionPane();
					jop3.showMessageDialog(null, "Adding user succes!!!!!!", "Information",JOptionPane.INFORMATION_MESSAGE);
					authentifier(login,pass);
					createUserJframe.dispose();				
				}
				else
				{
					JOptionPane jop3 = new JOptionPane();
					jop3.showMessageDialog(null, "Adding user fail!!!!!!", "Information",JOptionPane.INFORMATION_MESSAGE);
					createUserJframe.dispose();
					
				}
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	/**
	 * close the windows
	 */
	public void close()
	{
		createUserJframe.dispose();
	}
	

}
