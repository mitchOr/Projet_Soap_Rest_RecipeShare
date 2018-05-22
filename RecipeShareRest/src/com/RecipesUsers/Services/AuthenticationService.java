package com.RecipesUsers.Services;

import com.RecipesUsers.DAO.UserDao;

/**
 * 
 *  Class to authentificate a user
 *
 */
public class AuthenticationService{

    
	private UserDao userDao = new UserDao();
 
    /**
     * Connnecting a user
     * @param login
     * @param password
     * @return
     */
    public boolean connectionUser(String login , String password) 
    {
	    	if(userDao.isValidLogin(login, password))
	    	{
	           
            return true;
	    }
        
        return false;
    }

  
}
