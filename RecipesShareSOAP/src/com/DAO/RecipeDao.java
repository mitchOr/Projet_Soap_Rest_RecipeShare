package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.Entites.Recipe;


/**
 * Class RecipeDao
 * @author MichelNGAT
 *
 */
public class RecipeDao {

	/**
	 * Method to get All recipes
	 * @return
	 */
	public Recipe[] getAllRecipes(){
		
		String requete = "SELECT `IdRecipe`, `LibelleRecipe`, `DateCreation`, `IdUser` FROM `recipes` ;";
		Connection myConnect;
		Recipe recipeList[] = null;
		try {
			
			myConnect = DataBaseConnection.connectionBaseDonnes();
			Statement statement = myConnect.createStatement();
			ResultSet resultat = statement.executeQuery(requete);
			
			//get size of the result
			resultat.last(); // Positionne le curseur à la fin du resultSet
			int count = resultat.getRow(); // Récupère le nombre de records
			resultat.beforeFirst(); 

			//initialise the size
			 recipeList = new Recipe[count];
			
			/* Récupération des données du résultat de la requête de lecture */

			int index=0;//index du tableau 
			while ( resultat.next() ) {				
				int idRecipe = resultat.getInt( "IdRecipe" );
				String text = resultat.getString( "LibelleRecipe" );
				String dateCreation =resultat.getString("DateCreation");
				int idAuteur = resultat.getInt( "IdUser" );
				
				Recipe recipe=new Recipe(idRecipe, text, dateCreation, idAuteur);
				recipeList[index]=recipe;
				index++;
			}
			
			statement.close();
			myConnect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	      return recipeList;
	 }
	
	/**
	 * Method to get All recipes of one author
	 * @param id
	 * @return
	 */
	public Recipe[] getAllRecipesByID(int id){
		
		String requete = "SELECT `IdRecipe`, `LibelleRecipe`, `DateCreation`, `IdUser` FROM `recipes` WHERE IdUser =? ;";
		Connection myConnect;
		Recipe [] recipeList = null;
		int index=0;
		try {
			myConnect = DataBaseConnection.connectionBaseDonnes();
			PreparedStatement statement = myConnect.prepareStatement(requete);
			statement.setInt(1,id);
			
			ResultSet resultat = statement.executeQuery();
			resultat.last(); // Positionne le curseur à la fin du resultSet
			int count = resultat.getRow(); // Récupère le nombre de records
			resultat.beforeFirst();
		
			recipeList= new Recipe[count];

			
			while ( resultat.next() ) {
				int idRecipe = resultat.getInt( "IdRecipe" );
				String text = resultat.getString( "LibelleRecipe" );
				String dateCreation =resultat.getString("DateCreation");
				int idAuteur = resultat.getInt( "IdUser" );
				
				Recipe recipe=new Recipe(idRecipe, text, dateCreation, idAuteur);
				recipeList[index]=recipe;
				index++;
			}
			
			statement.close();
			myConnect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return recipeList;
		
	 }
	
	/**
	 * Method to get All recipes by date
	 * @param date
	 * @return
	 */
	public Recipe[] getAllRecipesByDate(String date){
		
		String requete = "SELECT `IdRecipe`, `LibelleRecipe`, `DateCreation`, `IdUser` FROM `recipes` WHERE DateCreation =? ;";
		Connection myConnect;
		Recipe[] recipeList = null;
		int index=0;
		try {
	
			myConnect = DataBaseConnection.connectionBaseDonnes();
			PreparedStatement statement = myConnect.prepareStatement(requete);
			statement.setString(1,date);
			
			ResultSet resultat = statement.executeQuery();
			resultat.last(); // Positionne le curseur à la fin du resultSet
			int count = resultat.getRow(); // Récupère le nombre de records
			resultat.beforeFirst();
		
			recipeList=new Recipe[count];//on initialise le tableau

			/* Récupération des données du résultat de la requête de lecture */
			
			while ( resultat.next() ) {
				int idRecipe = resultat.getInt( "IdRecipe" );
				String text = resultat.getString( "LibelleRecipe" );
				String dateCreation =resultat.getString("DateCreation");
				int idAuteur = resultat.getInt( "IdUser" );
				
				Recipe recipe=new Recipe(idRecipe, text, dateCreation, idAuteur);
				recipeList[index]=recipe;
				index++;
			}
			
			statement.close();
			myConnect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return recipeList;
		
	 }
		
	   /**
	    * Method to get a recipe
	    * @param id
	    * @return
	    */
	   public Recipe getRecipe(int id){
		   Recipe [] recipeList = getAllRecipes();

			for(Recipe recipe: recipeList){
				if(recipe.getId() == id){
					return recipe;
				}
			}
			return null;
		  
	   }
	   
	   /**
		 * id of a recipe
		 * @param recipe
		 * @return
		 */
		public int getIdRecipe(Recipe recipe){
			String requete = "SELECT `IdRecipe`, `LibelleRecipe`, `DateCreation`, `IdUser` FROM `recipes` WHERE `LibelleRecipe` = ? and `DateCreation` = ? and `IdUser` = ?;";
			Connection myConnect;
			int idRecipe = -1 ;
			try {
			
				myConnect = DataBaseConnection.connectionBaseDonnes();
				PreparedStatement statement = myConnect.prepareStatement(requete);
				statement.setString(1,recipe.getText());
				statement.setString(2,recipe.getCreationDate());
				statement.setInt(3,recipe.getId());
				
				ResultSet resultat = statement.executeQuery();
				
				
				while ( resultat.next() ) {
					idRecipe = resultat.getInt("IdRecipe");
				}
			
				statement.close();
				myConnect.close();
		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return idRecipe;
		}

	   
	   /**
	    * Method to add a recipe
	    * @param recipe
	    * @return
	    */
	   public boolean addRecipe(Recipe recipe){
	      
		String requete = "INSERT INTO `recipes` (`LibelleRecipe`, `DateCreation`, `IdUser`) VALUES  (?, ?, ?);";
		
		Connection myConnect;
		try {
				
			myConnect = DataBaseConnection.connectionBaseDonnes();
			PreparedStatement statement = myConnect.prepareStatement(requete);
			statement.setString(1,recipe.getText());
			statement.setString(2,recipe.getCreationDate());
			statement.setInt(3,recipe.getAuthor());
					
			statement.executeUpdate();
			statement.close();
			myConnect.close();
					
			return true;
					
					
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
		}
							
			return false;
	   }

	   /**
	    * Method to update a recipe
	    * @param pRecipe
	    * @return
	    */
	   public int updateRecipe(Recipe pRecipe){

			String requete = "UPDATE `recipes` SET `LibelleRecipe` = ?, `DateCreation` = ?, `IdUser` = ? WHERE `recipes`.`IdRecipe` = ?;";
			Connection myConnect;
			try {
			
				myConnect = DataBaseConnection.connectionBaseDonnes();
				PreparedStatement statement = myConnect.prepareStatement(requete);
				statement.setString(1,pRecipe.getText());
				statement.setString(2,pRecipe.getCreationDate());
				statement.setInt(3, pRecipe.getAuthor());
				statement.setInt(4, pRecipe.getId());
				statement.executeUpdate();
				statement.close();
				myConnect.close();
				
				
				return pRecipe.getId();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return -1;	
				
	   }

	   /**
	    * Method to delete a recipe
	    * @param id
	    * @return
	    */
	   public Boolean deleteRecipe(int id){
		 Recipe recipe = getRecipe(id);
			if(recipe!=null)
			{
				String requete = "DELETE FROM `recipes` WHERE IdRecipe = ?;";
				Connection myConnect;
				try {
				
					myConnect = DataBaseConnection.connectionBaseDonnes();
					PreparedStatement statement = myConnect.prepareStatement(requete);
					statement.setInt(1,id);
					
					statement.executeUpdate();
			
					statement.close();
					myConnect.close();
					
					return true;
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			return false;
	   }

	   

}
