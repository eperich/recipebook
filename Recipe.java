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
     
    /**
     * initialize new recipe
     */
    public Recipe() {
        this.recipeName = "";
        this.servings = 0; 
        this.recipeIngredients = null; 
        this.totalRecipeCalories = 0;
        this.recipeSteps = null;
        
    }
    
    /**
     * recipe constructor
     * @param recipeName
     * @param servings
     * @param recipeIngredients
     * @param totalRecipeCalories
     * @param recipeSteps 
     */
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
    
    /**
     * set recipe name
     * @param recipeName 
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    /**
     * get recipe name
     * @return recipe name
     */
    public String getRecipeName() {
        return recipeName;
    }
    
    /**
     * Set number of servings
     * @param servings 
     */
    public void setServings(int servings) {
        this.servings = servings;
    }
    
    /**
     * Get number of servings
     * @return servings
     */
    public int getServings() {
        return servings;
    }
    
    /**
     * Set recipe ingredients
     * @param recipeIngredients 
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    
    /**
     * Get recipe ingredients
     * @return recipe ingredients
     */
    public ArrayList getRecipeIngredients() {
        return recipeIngredients;
    }
    
    /**
     * Set total recipe calories
     * @param totalRecipeCalories 
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }
    
    /**
     * get total recipe calories
     * @return total recipe calories
     */
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }
    
    /**
     * set recipe steps
     * @param recipeSteps array list where each element is a step
     */
    public void setRecipeSteps(ArrayList<String> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
    
    /**
     * get recipe steps
     * @return array list where each element is a recipe step
     */
    public ArrayList getRecipeSteps() {
        return recipeSteps;
    }
    
    /**
     * print recipe
     */
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
    
    /**
     * create a new recipe
     * @return new recipe
     */
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


