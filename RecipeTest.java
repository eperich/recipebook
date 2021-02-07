/**
 * @author Erica Perich
 * 
 */

package FinalProject;

import java.util.ArrayList;



public class RecipeTest {

	/**
 	* @param args the command line arguments
 	*/
	public static void main(String[] args) {
		// Create two recipe objects first
		Recipe myFirstRecipe = new Recipe();
		ArrayList<Ingredient> recipeIngredients = new ArrayList<>(); 
		ArrayList<Ingredient> recipeIngredientsTwo = new ArrayList<>(); 
		Ingredient ingredientOne = new Ingredient();
                ingredientOne.setNameOfIngredient("butter");
		recipeIngredients.add(ingredientOne);
                ArrayList<String> recipeSteps = new ArrayList();
                recipeSteps.add("bake");
                ArrayList<String> recipeStepsTwo = new ArrayList();
                recipeStepsTwo.add("mix");
      
    	Recipe mySecondRecipe = new Recipe("Pizza", 2, recipeIngredients, 300, recipeSteps);
        Recipe recipe1 = new Recipe();
        recipe1 = recipe1.createNewRecipe();
   	 
    	// Initialize first recipe
        Ingredient ingredientTwo = new Ingredient();
        ingredientTwo.setNameOfIngredient("noodles");
	recipeIngredientsTwo.add(ingredientTwo);

    	myFirstRecipe.setRecipeName("Ramen");
    	myFirstRecipe.setServings(2);
    	myFirstRecipe.setRecipeIngredients(recipeIngredientsTwo);
    	myFirstRecipe.setTotalRecipeCalories(150);
        myFirstRecipe.setRecipeSteps(recipeStepsTwo);
   	 
    	// Print details of both recipes
    	myFirstRecipe.printRecipe();
    	mySecondRecipe.printRecipe();
        recipe1.printRecipe();
	}
     
}
