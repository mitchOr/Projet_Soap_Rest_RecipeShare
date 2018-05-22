package com.Services;

import com.DAO.UserDAO;

public class AuthenticationService{
   
	private UserDAO userDao = new UserDAO();
   
    public boolean connectionUser(String login , String password) {
    	if(userDao.isValidLogin(login, password))
    	{
           
            return true;
        }
        
        return false;
    }

  
}
