package com.service;

import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import com.model.*;

/**
 * Class to use Services of Recipe
 * 
 * @author MariamKonate
 *
 */
public class RecipeService {
	private Client client;
	private String REST_SERVICE_RECIPES_URL = "http://localhost:8080/RecipeShareRest/rest/RecipeService/recipes";
	private final String SUCCESS_RESULT = "<result>success</result>";
	private final String PASS = "pass";
	private final String FAIL = "fail";

	/**
	 * Initialize the service
	 */
	public void init() {
		this.client = ClientBuilder.newClient();
	}

	/**
	 * testGetAllRecipes
	 * 
	 * @return
	 */
	public List<Recipe> testGetAllRecipes() {
		GenericType<List<Recipe>> list = new GenericType<List<Recipe>>() {
		};
		List<Recipe> recipes = client.target(REST_SERVICE_RECIPES_URL).request(MediaType.APPLICATION_XML).get(list);
		String result = PASS;
		if (recipes.isEmpty()) {
			result = FAIL;
		}
		System.out.println("Test case name: testGetAllRecipes, Result: " + result);
		return recipes;
	}

	/**
	 * testGetAllRecipesOfAnAuthor
	 * 
	 * @param id
	 * @return
	 */
	public List<Recipe> testGetAllRecipesOfAnAuthor(int id) {
		GenericType<List<Recipe>> list = new GenericType<List<Recipe>>() {
		};
		List<Recipe> recipes = client.target(REST_SERVICE_RECIPES_URL + "ById").path("/{userid}")
				.resolveTemplate("userid", id).request(MediaType.APPLICATION_XML).get(list);
		String result = PASS;
		if (recipes.isEmpty()) {
			result = FAIL;
		}
		System.out.println("Test case name: testGetAllRecipesOfAnAuthor, Result: " + result);
		return recipes;
	}

	/**
	 * testGetAllRecipesByDate
	 * 
	 * @param date
	 * @return
	 */
	public List<Recipe> testGetAllRecipesByDate(String date) {
		GenericType<List<Recipe>> list = new GenericType<List<Recipe>>() {
		};
		List<Recipe> recipes = client.target(REST_SERVICE_RECIPES_URL + "ByDate").path("/{creationDate}")
				.resolveTemplate("creationDate", date).request(MediaType.APPLICATION_XML).get(list);
		String result = PASS;
		if (recipes.isEmpty()) {
			result = FAIL;
		}
		System.out.println("Test case name: testGetAllRecipesByDate, Result: " + result);
		return recipes;
	}

	/**
	 * testGetRecipe
	 * 
	 * @param id
	 * @return
	 */
	public Recipe testGetRecipe(int id) {
		Recipe sampleRecipe = new Recipe();
		sampleRecipe.setId(id);
		String service = "http://localhost:8080/RecipeShareRest/rest/RecipeService/recipesId";
		Recipe recipe = client.target(service).path("/{recipeId}").resolveTemplate("recipeId", id)
				.request(MediaType.APPLICATION_XML).get(Recipe.class);
		String result = FAIL;
		if (sampleRecipe != null && sampleRecipe.getId() == recipe.getId()) {
			result = PASS;
		}
		System.out.println("Test case name: testGetRecipe, Result: " + result);
		return recipe;
	}

	/**
	 * testUpdateRecipe
	 * 
	 * @param id
	 * @param body
	 * @param date
	 * @param author
	 * @return
	 */
	public String testUpdateRecipe(int id, String body, String date, int author) {
		Form form = new Form();
		form.param("id", "" + id);
		form.param("text", body);
		form.param("creationDate", date);
		form.param("Author", "" + author);

		String callResult = client.target(REST_SERVICE_RECIPES_URL).request(MediaType.APPLICATION_XML)
				.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testUpdateRecipe, Result: " + result);
		return result;
	}

	/**
	 * testAddRecipe
	 * 
	 * @param text
	 * @param date
	 * @param author
	 * @return
	 */
	public String testAddRecipe(String text, String date, int author) {
		Form form = new Form();
		form.param("text", text);
		form.param("creationDate", date);
		form.param("Author", "" + author);

		String callResult = client.target(REST_SERVICE_RECIPES_URL).request(MediaType.APPLICATION_XML)
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testAddRecipe, Result: " + result);
		return result;
	}

	/**
	 * testDeleteRecipe
	 * 
	 * @param id
	 * @return
	 */
	public String testDeleteRecipe(int id) {
		String callResult = client.target(REST_SERVICE_RECIPES_URL).path("/{recipeId}").resolveTemplate("recipeId", id)
				.request(MediaType.APPLICATION_XML).delete(String.class);

		String result = PASS;
		if (!SUCCESS_RESULT.equals(callResult)) {
			result = FAIL;
		}

		System.out.println("Test case name: testDeleteRecipe, Result: " + result);
		return result;
	}

	public static void main(String[] args) {
		RecipeService tester = new RecipeService();
		// initialize the tester
		tester.init();

		// test get all recipes Web Service Method
		tester.testGetAllRecipes();
		// test get all recipes of a user Web Service Method
		tester.testGetAllRecipesOfAnAuthor(6);
		// test get all recipes created at a certain date Web Service Method
		tester.testGetAllRecipesByDate("2018-05-20");

		// test get recipes Web Service Method
		Recipe rep = tester.testGetRecipe(37);

		// test update recipe Web Service Method
		tester.testUpdateRecipe(rep.getId(), rep.getText(), rep.getCreationDate(), rep.getAuthor());

		// test add recipe Web Service Method
		tester.testAddRecipe(rep.getText(), rep.getCreationDate(), rep.getAuthor());

		// test delete recipe Web Service Method
		tester.testDeleteRecipe(8);
	}
}
