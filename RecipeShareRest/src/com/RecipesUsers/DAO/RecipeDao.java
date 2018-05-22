package com.RecipesUsers.DAO;

import java.sql.*;
import java.util.*;

import com.RecipesUsers.Entities.Recipe;

/**
 * Class RecipeDao
 * 
 * @author MariamKonate
 *
 */
public class RecipeDao {

	/**
	 * Method to get All recipes
	 * 
	 * @return
	 */
	public List<Recipe> getAllRecipes() {

		String requete = "SELECT `IdRecipe`, `LibelleRecipe`, `DateCreation`, `IdUser` FROM `recipes` ;";
		Connection myConnect;
		List<Recipe> recipeList = null;
		try {
			recipeList = new ArrayList<>();
			myConnect = DataBaseConnection.connectionBaseDonnes();
			Statement statement = myConnect.createStatement();
			ResultSet resultat = statement.executeQuery(requete);

			/* Récupération des données du résultat de la requête de lecture */

			while (resultat.next()) {
				int idRecipe = resultat.getInt("IdRecipe");
				String text = resultat.getString("LibelleRecipe");
				String dateCreation = resultat.getString("DateCreation");
				int idAuteur = resultat.getInt("IdUser");

				Recipe recipe = new Recipe(idRecipe, text, dateCreation, idAuteur);
				recipeList.add(recipe);
			}

			statement.close();
			myConnect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recipeList;
	}

	/**
	 * Method to get All recipes of one author
	 * 
	 * @param id
	 * @return
	 */
	public List<Recipe> getAllRecipes(int id) {

		String requete = "SELECT `IdRecipe`, `LibelleRecipe`, `DateCreation`, `IdUser` FROM `recipes` WHERE IdUser =? ;";
		Connection myConnect;
		List<Recipe> recipeList = null;
		try {
			recipeList = new ArrayList<>();
			myConnect = DataBaseConnection.connectionBaseDonnes();
			PreparedStatement statement = myConnect.prepareStatement(requete);
			statement.setInt(1, id);

			ResultSet resultat = statement.executeQuery();

			/* Récupération des données du résultat de la requête de lecture */

			while (resultat.next()) {
				int idRecipe = resultat.getInt("IdRecipe");
				String text = resultat.getString("LibelleRecipe");
				String dateCreation = resultat.getString("DateCreation");
				int idAuteur = resultat.getInt("IdUser");

				Recipe recipe = new Recipe(idRecipe, text, dateCreation, idAuteur);
				recipeList.add(recipe);
			}

			statement.close();
			myConnect.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return recipeList;
	}

	/**
	 * Method to get All recipes by date
	 * 
	 * @param date
	 * @return
	 */
	public List<Recipe> getAllRecipes(String date) {

		String requete = "SELECT `IdRecipe`, `LibelleRecipe`, `DateCreation`, `IdUser` FROM `recipes` WHERE DateCreation =? ;";
		Connection myConnect;
		List<Recipe> recipeList = null;
		try {
			recipeList = new ArrayList<>();
			myConnect = DataBaseConnection.connectionBaseDonnes();
			PreparedStatement statement = myConnect.prepareStatement(requete);
			statement.setString(1, date);

			ResultSet resultat = statement.executeQuery();

			/* Récupération des données du résultat de la requête de lecture */

			while (resultat.next()) {
				int idRecipe = resultat.getInt("IdRecipe");
				String text = resultat.getString("LibelleRecipe");
				String dateCreation = resultat.getString("DateCreation");
				int idAuteur = resultat.getInt("IdUser");

				Recipe recipe = new Recipe(idRecipe, text, dateCreation, idAuteur);
				recipeList.add(recipe);
			}

			statement.close();
			myConnect.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return recipeList;

	}

	/**
	 * Method to get a recipe
	 * 
	 * @param id
	 * @return
	 */
	public Recipe getRecipe(int id) {
		List<Recipe> recipeList = getAllRecipes();

		for (Recipe recipe : recipeList) {
			if (recipe.getId() == id) {
				return recipe;
			}
		}
		return null;
	}

	/**
	 * method to get the id of a recipe
	 * 
	 * @param recipe
	 * @return
	 */
	public int getIdRecipe(Recipe recipe) {
		String requete = "SELECT `IdRecipe`, `LibelleRecipe`, `DateCreation`, `IdUser` FROM `recipes` WHERE `LibelleRecipe` = ? and `DateCreation` = ? and `IdUser` = ?;";
		Connection myConnect;
		int idRecipe = -1;
		try {

			myConnect = DataBaseConnection.connectionBaseDonnes();
			PreparedStatement statement = myConnect.prepareStatement(requete);
			statement.setString(1, recipe.getText());
			statement.setString(2, recipe.getCreationDate());
			statement.setInt(3, recipe.getAuthor());

			ResultSet resultat = statement.executeQuery();

			while (resultat.next()) {
				idRecipe = resultat.getInt("IdRecipe");
			}

			statement.close();
			myConnect.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return idRecipe;
	}

	/**
	 * Method to add a recipe
	 * 
	 * @param recipe
	 * @return
	 */
	public int addRecipe(Recipe recipe) {

		String requete = "INSERT INTO `recipes` (`LibelleRecipe`, `DateCreation`, `IdUser`) VALUES  (?, ?, ?);";

		Connection myConnect;
		try {

			myConnect = DataBaseConnection.connectionBaseDonnes();
			PreparedStatement statement = myConnect.prepareStatement(requete);
			statement.setString(1, recipe.getText());
			statement.setString(2, recipe.getCreationDate());
			statement.setInt(3, recipe.getAuthor());

			statement.executeUpdate();
			statement.close();
			myConnect.close();

			return getIdRecipe(recipe);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return -1;
	}

	/**
	 * Method to update a recipe
	 * 
	 * @param pRecipe
	 * @return
	 */
	public int updateRecipe(Recipe pRecipe) {

		String requete = "UPDATE `recipes` SET `LibelleRecipe` = ?, `DateCreation` = ?, `IdUser` = ? WHERE `recipes`.`IdRecipe` = ?;";
		Connection myConnect;
		try {

			myConnect = DataBaseConnection.connectionBaseDonnes();
			PreparedStatement statement = myConnect.prepareStatement(requete);
			statement.setString(1, pRecipe.getText());
			statement.setString(2, pRecipe.getCreationDate());
			statement.setInt(3, pRecipe.getAuthor());
			statement.setInt(4, pRecipe.getId());
			statement.executeUpdate();
			statement.close();
			myConnect.close();

			return pRecipe.getId();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return -1;
	}

	/**
	 * Method to delete a recipe
	 * 
	 * @param id
	 * @return
	 */
	public int deleteRecipe(int id) {
		Recipe recipe = getRecipe(id);
		if (recipe != null) {
			String requete = "DELETE FROM `recipes` WHERE IdRecipe = ?;";
			Connection myConnect;
			try {

				myConnect = DataBaseConnection.connectionBaseDonnes();
				PreparedStatement statement = myConnect.prepareStatement(requete);
				statement.setInt(1, id);

				statement.executeUpdate();

				statement.close();
				myConnect.close();

				return recipe.getId();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return -1;
	}

}
