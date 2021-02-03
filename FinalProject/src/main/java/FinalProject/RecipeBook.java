package FinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class RecipeBook {
	

    private ArrayList<Recipe> listOfRecipes;
    
    public ArrayList getListOfRecipes() {
        return this.listOfRecipes;
    }
    
    public void setListOfRecipes(ArrayList recipeList) {
        this.listOfRecipes = recipeList;
    }
    
    public RecipeBook() {
        this.listOfRecipes = new ArrayList();
    }
    
    public RecipeBook(ArrayList recipeList) {
        this.listOfRecipes = recipeList;
    }
    
    // print recipe details
    public void printAllRecipeDetails(String recipeName) {
        int i = 0;
        for (i = 0; i < listOfRecipes.size(); ++i) {
            Recipe listRecipe = listOfRecipes.get(i); 
            if (recipeName.equals(listRecipe.getRecipeName())) {
                listRecipe.printRecipe();
            }
        }
    }
    
    // print recipe details
    public void printAllRecipeSteps(String recipeName) {
        int i = 0;
        ArrayList<String> tempRecipeSteps = new ArrayList<>();
        for (i = 0; i < listOfRecipes.size(); ++i) {
            Recipe listRecipe = listOfRecipes.get(i); 
            if (recipeName.equals(listRecipe.getRecipeName())) {
                tempRecipeSteps = listRecipe.getRecipeSteps();
            }
        }
        
        for (i = 0; i < tempRecipeSteps.size(); ++i) {
            System.out.println(i + 1 + ". " + tempRecipeSteps.get(i));
        }
    }
    
    // print recipe list
    public void printAllRecipeNames() {
        int i = 0;
        for (i = 0; i < listOfRecipes.size(); ++i) {
            Recipe listRecipe = listOfRecipes.get(i);
            System.out.println(listRecipe.getRecipeName());
                    }
    }
    
    // add recipe 
    public void newRecipe() {
        Recipe tmpRecipe = new Recipe().createNewRecipe();
        listOfRecipes.add(tmpRecipe);
        
    }
	 
	
	/**
	* A variation of following menu method should be used as the actual main 
	*		once you are ready to submit your final application.  For this 
	*		submission and for using it to do stand-alone tests, replace the 
	*		public void menu() with the standard 
	*			public static main(String[] args)
	*		method
	*
	*/
	
	public static void main(String[] args) {
    	// Create a Recipe Box
    		
	RecipeBook myRecipeBox = new RecipeBook(); 
        Scanner menuScnr = new Scanner(System.in);
        
		
		/**
		* Print a menu for the user to select one of the three options:
		*
		*/
		
		System.out.println("Menu\n" + "1. Add Recipe\n" + 
                        "2. Print All Recipe Details\n" + 
                        "3. Print All Recipe Steps\n" +
                        "4. Print All Recipe Names\n" + 
                        "\nPlease select a menu item:");
        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
            int input = menuScnr.nextInt();
            switch(input) {
                case 1:
                    myRecipeBox.newRecipe();
                    break;
                case 2:
                    System.out.println("Enter the name of the recipe: ");
                    String recipeName = menuScnr.next();
                    myRecipeBox.printAllRecipeDetails(recipeName);
                    break;
                case 3:
                    System.out.println("Enter the name of the recipe: ");
                    recipeName = menuScnr.next();
                    myRecipeBox.printAllRecipeSteps(recipeName);
                    break;
                case 4:
                    myRecipeBox.printAllRecipeNames();
                    break;
                default:
                    System.out.println("That's not a valid input.");
            }
            
            System.out.println("Menu\n" + "1. Add Recipe\n" + 
                        "2. Print All Recipe Details\n" + 
                        "3. Print All Recipe Steps\n" +
                        "4. Print All Recipe Names\n" +
                        "\nPlease select a menu item:");
            }
		
        
	}
        

}


/**
 * 
 * Final Project Details:
 * 
 * For your final project submission, you should add a menu item and a method 
 *		to access the custom method you developed for the Recipe class 
 * 		based on the Stepping Stone 5 Lab.
 *
 */