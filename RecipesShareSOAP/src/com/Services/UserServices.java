package com.Services;
import com.DAO.UserDAO;
import com.Entites.User;

public class UserServices {

	   UserDAO userDao = new UserDAO();
	   private static final String SUCCESS_RESULT="success";
	   private static final String FAILURE_RESULT="failure";


	   /**
	    * Method to get all users
	    * @return
	    */
	
	   public User[] getUsers(){
	      return userDao.getAllUsers();
	   }

	   /**
	    * Method to get one user
	    * @param userid
	    * @return
	    */
	   public User getUser( int userid){
	      return userDao.getUser(userid);
	   }
	   
	   /**
	    * get by login and Password
	    * @param login
	    * @param pass
	    * @return
	    */
	   public User getUserbyLogPass(String login, String pass)
	   {
		   return userDao.getByLoginAndPass(login, pass);
	   }

	   /**
	    * Method to create a user
	    * @param id
	    * @param fName
	    * @param lName
	    * @param birthDate
	    * @param login
	    * @param password
	    * @param servletResponse
	    * @return
	    * @throws IOException
	    */

	   public String createUser(int id,String fName, String lName, String birthDate, String login,String password) 
	   {
	      User user = new User(id, fName, lName,birthDate,login,password);
	      int result = userDao.addUser(user);
	      if(result == -1){
	         return FAILURE_RESULT;
	      }
	      return SUCCESS_RESULT;
	   }

	   /**
	    * Method to update a user
	    * @param id
	    * @param fName
	    * @param lName
	    * @param birthDate
	    * @param login
	    * @param password
	    * @param servletResponse
	    * @return
	    * @throws IOException
	    */
	   
	   public String updateUser(int id,String fName, String lName,String birthDate,String login, String password) 
	   {
		   User user = new User(id, fName, lName,birthDate,login,password);
	       int result = userDao.updateUser(user);
	       if(result != -1){
	         return SUCCESS_RESULT;
	       }
	       return FAILURE_RESULT;
	   }

	   /**
	    * Method to delete a user
	    * @param userid
	    * @return
	    */
	   public String deleteUser( int userid){
	      int result = userDao.deleteUser(userid);
	      if(result != -1){
	         return SUCCESS_RESULT;
	      }
	      return FAILURE_RESULT;
	   }


}
