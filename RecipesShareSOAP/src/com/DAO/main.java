package com.DAO;
import com.Entites.Recipe;
import com.Entites.User;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	UserDAO user = new UserDAO();
		System.out.println(user.isValidLogin("admin", "pass"));
		System.out.println(user.isValidLogin("root", "pass"));
		System.out.println(user.isValidLogin("kaker", "kakr"));
		User[] liste = user.getAllUsers();
		for(User rt : liste)
		{
			System.out.println(rt.getfirstName());
		}*/
		
		
		RecipeDao recipe = new RecipeDao();
		Recipe r= new Recipe("test1", "2015-20-20",1);
		System.out.println(recipe.addRecipe(r));
		/*int res =recipe.addRecipe(test);
		 Recipe[] liste2 = recipe.getAllRecipes();
		System.out.println("la taille est" +liste2.length);
		for(Recipe i : liste2)
	
			System.out.println(i.getText()+" "+i.getCreationDate());
		}*/
		 
		}

}
