package com.Services;
import com.DAO.RecipeDao;
import com.Entites.Recipe;

public class RecipeServices {
	

	RecipeDao recipeDao = new RecipeDao();
    private static final String SUCCESS_RESULT="success";
    private static final String FAILURE_RESULT="failure";
    
    
    /**
     * Method to get all recipes
     * @return
     */
    public Recipe[] getRecipes(){
       return recipeDao.getAllRecipes();
    }

    /**
     * Method to get all recipes for one user
     * @param userid
     * @return
     */
    public Recipe[] getRecipesByID(int userid){
        return recipeDao.getAllRecipes();
     }
    
   
    /**
     * Method to get one recipe
     * @param recipeId
     * @return
     */
    public Recipe getRecipeByID( int recipeId){
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
  
    public String createRecipe(String text, String creationDate,int Author){
       Recipe recipe = new Recipe( text, creationDate,Author);
       boolean result = recipeDao.addRecipe(recipe);
       if(result == false){
          return FAILURE_RESULT ;
       }     
    	   return SUCCESS_RESULT ;
       
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
    public String updateRecipe( int id,String text,String creationDate,int Author) 
    {
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
    public String deleteRecipe(int recipeId){
       Boolean result = recipeDao.deleteRecipe(recipeId);
       if(result != true){
          return FAILURE_RESULT;
       }
       return SUCCESS_RESULT;
    }

}
