package com.RecipesUsers.Services;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.RecipesUsers.DAO.RecipeDao;
import com.RecipesUsers.Entities.Recipe;

/**
 * 
 * @author MariamKonate
 *
 */
@Path("/RecipeService")
public class RecipeService {
	
	RecipeDao recipeDao = new RecipeDao();
    private static final String SUCCESS_RESULT="<result>success</result>";
    private static final String FAILURE_RESULT="<result>failure</result>";
    
    
    /**
     * Method to get all recipes
     * @return
     */
    @GET
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_XML)
    public List<Recipe> getRecipes(){
       return recipeDao.getAllRecipes();
    }

    /**
     * Method to get all recipes for one user
     * @param userid
     * @return
     */
    @GET
    @Path("/recipesById/{userid}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Recipe> getRecipes(@PathParam("userid") int userid){
        return recipeDao.getAllRecipes(userid);
     }
    
    /**
     * Method to get all recipes for one user
     * @param userid
     * @return
     */
    @GET
    @Path("/recipesByDate/{creationDate}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Recipe> getRecipes(@PathParam("creationDate") String creationDate){
        return recipeDao.getAllRecipes(creationDate);
     }
    
    /**
     * Method to get one recipe
     * @param recipeId
     * @return
     */
    
    @GET
    @Path("/recipesId/{recipeId}")
    @Produces(MediaType.APPLICATION_XML)
    public Recipe getRecipe(@PathParam("recipeId") int recipeId){
       return recipeDao.getRecipe(recipeId);
    }
    
    /**
     * Method to create a recipe
     * @param id
     * @param text
     * @param creationDate
     * @param Author
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @POST
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createRecipe(@FormParam("id") int id,
	   @FormParam("text") String text,
	   @FormParam("creationDate") String creationDate,
	   @FormParam("Author") int Author,
	   @Context HttpServletResponse servletResponse) throws IOException{
       Recipe recipe = new Recipe(id, text, creationDate,Author);
       int result = recipeDao.addRecipe(recipe);
       if(result != -1){
          return SUCCESS_RESULT;
       }
       return FAILURE_RESULT;
    }

    /**
     * Method to update a recipe
     * @param id
     * @param text
     * @param creationDate
     * @param Author
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @PUT
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateRecipe(@FormParam("id") int id,
    	   @FormParam("text") String text,
	   @FormParam("creationDate") String creationDate,
	   @FormParam("Author") int Author,
       @Context HttpServletResponse servletResponse) throws IOException{
    	   Recipe recipe = new Recipe(id, text, creationDate,Author);
    	   int result = recipeDao.updateRecipe(recipe);
       if(result != -1){
          return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    /**
     * Method to delete a recipe
     * @param recipeId
     * @return
     */
    @DELETE
    @Path("/recipes/{recipeId}")
    @Produces(MediaType.APPLICATION_XML)
    public String deleteRecipe(@PathParam("recipeId") int recipeId){
       int result = recipeDao.deleteRecipe(recipeId);
       if(result != -1){
          return SUCCESS_RESULT;
       }
       return FAILURE_RESULT;
    }

    /**
     * get the supported Operations
     * @return
     */
    @OPTIONS
    @Path("/recipes")
    @Produces(MediaType.APPLICATION_XML)
    public String getSupportedOperations(){
       return "<operations>GET, PUT, POST, DELETE</operations>";
    }

}
