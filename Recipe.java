/**
 * @author Erica Perich
 * 
 */
package FinalProject;

import java.util.Scanner;
import java.util.ArrayList;

public class Recipe {
    
    private String recipeName;
    private int servings;
    ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
    private double totalRecipeCalories;
    ArrayList<String> recipeSteps = new ArrayList<>();
     
    // recipe initialization
    public Recipe() {
        this.recipeName = "";
        this.servings = 0; 
        this.recipeIngredients = null; 
        this.totalRecipeCalories = 0;
        this.recipeSteps = null;
        
    }
    
    // recipe assignments
    public Recipe(String recipeName, int servings, 
    	ArrayList<Ingredient> recipeIngredients, double totalRecipeCalories, 
        ArrayList<String> recipeSteps) 
    {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.totalRecipeCalories = totalRecipeCalories;
        this.recipeSteps = recipeSteps;
    }
    
    // set recipe name
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    // get recipe name
    public String getRecipeName() {
        return recipeName;
    }
    
    // set number of servings
    public void setServings(int servings) {
        this.servings = servings;
    }
    
    // get number of servings
    public int getServings() {
        return servings;
    }
    
    // set recipe ingredients
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    
    // get recipe ingredients
    public ArrayList getRecipeIngredients() {
        return recipeIngredients;
    }
    
    // set total recipe calories
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    // get total recipe calories
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }
    
    // set recipe steps
    public void setRecipeSteps(ArrayList<String> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
    
    // get recipe steps
    public ArrayList getRecipeSteps() {
        return recipeSteps;
    }
    
    // print recipe
    public void printRecipe() {
        int singleServingCalories = 0;
        double singleServingCaloriesDouble = 0.0;
        singleServingCaloriesDouble = totalRecipeCalories / servings;
        singleServingCalories = (int)singleServingCaloriesDouble;
         
        System.out.println("Recipe: " + recipeName);
        System.out.println("Serves: " + servings);
        System.out.println("Ingredients: ");
        
        int i = 0;
        for (i = 0; i < recipeIngredients.size(); ++i) {
            Ingredient tempIngredient = recipeIngredients.get(i);
            tempIngredient.printIngredient();
        }
        
        System.out.println("Each serving has " + singleServingCalories + " Calories.");
        
        System.out.println("Steps: ");
        i = 0;
        for (i = 0; i < recipeSteps.size(); ++i) {
            System.out.println(i + 1 + ". " + recipeSteps.get(i));
        }
    }
    
    // create a new recipe
    public Recipe createNewRecipe() {
        double tempTotalRecipeCalories = 0;
        ArrayList<Ingredient> tempRecipeIngredients = new ArrayList<>();
        ArrayList<String> tempRecipeSteps = new ArrayList<>();
        boolean addMoreIngredients = true;
        boolean addMoreSteps = true;
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Please enter the recipe name: ");
        String tempRecipeName = scnr.nextLine();
        
        System.out.println("Please enter the number of servings: ");
        int tempServings = scnr.nextInt(); 
        
                
        do {
            System.out.println("Please enter the ingredient name "
                    + "or type end if you are finished entering ingredients: ");
            String ingredientName = scnr.next();
            if (ingredientName.toLowerCase().equals("end")) {
                addMoreIngredients = false;
            } else {
                Ingredient tempIngredient = new Ingredient();
                tempIngredient.addIngredient(ingredientName);

                tempRecipeIngredients.add(tempIngredient);
                
                tempTotalRecipeCalories += tempIngredient.getNumberCaloriesPerCup() * tempIngredient.getNumberCups();
            
            }
           
       } while (addMoreIngredients) ;
        
        int i = 1;
        do {
            System.out.println("Please enter the next step"
                    + " or type end if you are finished entering steps: ");
            String recipeStep = scnr.next();
            if (recipeStep.toLowerCase().equals("end")) {
                addMoreSteps = false;
            } else {

                tempRecipeSteps.add(recipeStep);
                ++i;
            }
           
       } while (addMoreSteps) ;
        
        Recipe recipe1 = new Recipe(tempRecipeName, 
            tempServings, tempRecipeIngredients, tempTotalRecipeCalories, tempRecipeSteps);
        
        return recipe1;
    }
}


/**
 * Final Project
 * 
 * For your Final Project:
 * 
 * 1. Modify this code to develop a Recipe class:
 *	a. change the void main method createNewRecipe() that returns a Recipe 
 * 	 
 * 2. FOR FINAL SUBMISSION ONLY:Change the ArrayList type to an 
 *		Ingredient object.  When a user adds an ingredient to the recipe, 
 * 		instead of adding just the ingredient name, you will be adding the 
 *		actual ingredient including name, amount, measurement type, calories.
 *	For the Milestone Two submission, the recipeIngredients ArrayList can
 *	remain as a String type.
 *
 * 3. Adapt the printRecipe() method to print the amount and measurement
 * 	type as well as the ingredient name.
 *
 * 4. Create a custom method in the Recipe class. 
 *      Choose one of the following options:
 *
 * 	a. print out a recipe with amounts adjusted for a different 
 * 		number of servings
 * 
 * 	b. create an additional list or ArrayList that allow users to 
 * 		insert step-by-step recipe instructions
 *
 * 	c. conversion of ingredient amounts from 
 * 		English to metric (or vice versa)
 *
 * 	d. calculate select nutritional information 
 *
 * 	e. calculate recipe cost
 * 
 *      f. propose a suitable alternative to your instructor
 * 
 */ 



