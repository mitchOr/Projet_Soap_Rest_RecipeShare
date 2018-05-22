package com.RecipesUsers.Services;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.RecipesUsers.DAO.UserDao;
import com.RecipesUsers.Entities.User;

/**
 * 
 * @author MariamKonate
 *
 */
@Path("/UserService")
public class UserService {
	
   UserDao userDao = new UserDao();
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";


   /**
    * Method to get all users
    * @return
    */
   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public List<User> getUsers(){
      return userDao.getAllUsers();
   }

   /**
    * Method to get one user
    * @param userid
    * @return
    */
   @GET
   @Path("/users/{userid}")
   @Produces(MediaType.APPLICATION_XML)
   public User getUser(@PathParam("userid") int userid){
      return userDao.getUser(userid);
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
   @POST
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String createUser(@FormParam("id") int id,
      @FormParam("fName") String fName,
      @FormParam("lName") String lName,
      @FormParam("birthDate") String birthDate,
      @FormParam("login") String login,
      @FormParam("password") String password,
      @Context HttpServletResponse servletResponse) throws IOException{
      User user = new User(id, fName, lName,birthDate,login,password);
      int result = userDao.addUser(user);
      if(result !=- 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
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
   @PUT
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updateUser(@FormParam("id") int id,
	   @FormParam("fName") String fName,
       @FormParam("lName") String lName,
       @FormParam("birthDate") String birthDate,
       @FormParam("login") String login,
       @FormParam("password") String password,
       @Context HttpServletResponse servletResponse) throws IOException{
	   User user = new User(id, fName, lName,birthDate,login,password);
       int result = userDao.updateUser(user);
       if(result !=- 1){
         return SUCCESS_RESULT;
       }
       return FAILURE_RESULT;
   }

   /**
    * Method to delete a user
    * @param userid
    * @return
    */
   @DELETE
   @Path("/users/{userid}")
   @Produces(MediaType.APPLICATION_XML)
   public String deleteUser(@PathParam("userid") int userid){
      int result = userDao.deleteUser(userid);
      if(result !=- 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   /**
    * get the supported Operations
    * @return
    */
   @OPTIONS
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public String getSupportedOperations(){
      return "<operations>GET, PUT, POST, DELETE</operations>";
   }
}