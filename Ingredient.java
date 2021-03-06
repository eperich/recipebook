/**
 * @author Erica Perich
 * 
 */
package FinalProject;

import java.util.Scanner;

public class Ingredient {
    private String nameOfIngredient; // ingredient name
    private String unitOfMeasurement; // unit of measurement (c, Tbsp, tsp, oz, mL)
    private float ingredientAmount; // ingredient amount in given unit
    private float numberCups; // number of cups calculated from amount, unit
    private int numberCaloriesPerCup; // number of calories per cup
    private final double totalCalories; // total calories
    
    /**
     * 
     * @param ingredientAmount ingredient amount
     * @param unitOfMeasurement unit of measurement
     * @return number of cups
     */
    private float calculateNumberCups(float ingredientAmount, String unitOfMeasurement) {
        float tempNumberCups = 0;
        switch(unitOfMeasurement){
           case "c":
               tempNumberCups = ingredientAmount;
               break;
           case "Tbsp":
               tempNumberCups = ingredientAmount / 16;
               break;
           case "tsp":
               tempNumberCups = ingredientAmount / 48;
               break;
           case "oz":
               tempNumberCups = ingredientAmount / 8;
               break;
           case "mL":
               tempNumberCups = ingredientAmount / 237;
               break;
        }
        return tempNumberCups;
    }
    
    /**
     * 
     * @return name of ingredient
     */
    public String getNameOfIngredient() {
    return nameOfIngredient;
    }
    
    /**
     * set name of ingredient
     * @param nameOfIngredient name of ingredient
     */
    public void setNameOfIngredient (String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }
    
    /**
     * 
     * @return number of cups
     */
    public float getNumberCups() {
        return numberCups;
    }
    
    /**
     * set number of cups
     * @param numberCups number of cups
     */
    public void setNumberCups(float numberCups) {
        this.numberCups = numberCups;
    }
    
    /**
     * 
     * @return ingredient amount
     */
    public float getIngredientAmount() {
        return ingredientAmount;
    }
    
    /**
     * set ingredient amount
     * @param ingredientAmount ingredient amount
     */
    public void setIngredientAmount(float ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }
    
    /**
     * 
     * @return unit of measurement
     */
    public String getUnitofMeasurement() {
        return unitOfMeasurement;
    }
    
    /**
     * set unit of measurement
     * @param unitOfMeasurement unit of measurement
     */
    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
    
    /**
     * 
     * @return number of calories per cup
     */
    public int getNumberCaloriesPerCup() {
        return numberCaloriesPerCup;
    }
    
    /**
     * set number of calories per cup
     * @param numberCaloriesPerCup number of calories per cup
     */
    public void setNumberCaloriesPerCup(int numberCaloriesPerCup) {
        this.numberCaloriesPerCup = numberCaloriesPerCup;
    }
    
    /**
     * 
     * @return total calories
     */
    public double getTotalCalories() {
        return totalCalories;
    }
    
    /**
     * initialize ingredient object
     */
    public Ingredient() {
        this.nameOfIngredient = "";
        this.unitOfMeasurement = "";
        this.ingredientAmount = 0;
        this.numberCaloriesPerCup = 0;
        this.numberCups = 0;
        this.totalCalories = 0;
        
    }
    
    /**
     * ingredient object constructor
     * @param nameOfIngredient ingredient name
     * @param unitOfMeasurement unit of measurement
     * @param ingredientAmount ingredient amount
     * @param numberCaloriesPerCup number of calories per cup
     * @param totalCalories total calories
     */
    public Ingredient(String nameOfIngredient, String unitOfMeasurement, 
            float ingredientAmount, int numberCaloriesPerCup, float totalCalories) {
        this.nameOfIngredient = nameOfIngredient;
        this.unitOfMeasurement = unitOfMeasurement;
        this.ingredientAmount = ingredientAmount;
        this.numberCaloriesPerCup = numberCaloriesPerCup;
        this.numberCups = this.calculateNumberCups(ingredientAmount, unitOfMeasurement);
        this.totalCalories = totalCalories;
        
    }
    
    
    /**
     * create new ingredient
     * @param tempNameOfIngredient ingredient name
     * @return new ingredient
     */
    public Ingredient addIngredient(String tempNameOfIngredient) {
       String tempUnitOfMeasurement;
       float tempIngredientAmount;
       float tempNumberCups;
       int tempNumberCaloriesPerCup;
       float tempTotalCalories; 
       Scanner scnr = new Scanner(System.in);
       
       // check for string input
       if (!(tempNameOfIngredient instanceof String)) {
           System.out.println("Please enter a valid name: ");
           tempNameOfIngredient = scnr.next();
           if (!(tempNameOfIngredient instanceof String)) {
               System.out.println("Sorry, that's not valid. Restart the "
                       + "program to try again."); 
            }
           else {
               System.out.println("Thank you!");
           }
       }
       else {
           System.out.println("Thank you!");
       }
       
       // unit of measurement user input
       System.out.println("Please enter the unit of measurement for "
               + "this ingredient. You may enter c, Tbsp, tsp, oz, or mL");
       tempUnitOfMeasurement = scnr.next();
       
       // check for String type
       if (!(tempUnitOfMeasurement instanceof String)) {
           System.out.println("Please enter a valid unit of measurement.");
           tempUnitOfMeasurement = scnr.next();
           if (!(tempUnitOfMeasurement instanceof String)) {
               System.out.println("Sorry, that's not valid. Restart the "
                       + "program to try again.");
           }
           else {
               System.out.println("Thank you!");
           }
       }
       else {
           System.out.println("Thank you!");
       }
       
       // amount of ingredient in given unit user input
       System.out.println("Please enter the number of " + tempUnitOfMeasurement + " of " 
        + tempNameOfIngredient + " we'll need: ");
       tempIngredientAmount = scnr.nextFloat();
           
       // calories per cup user input
       System.out.println("Please enter the number of calories per cup: ");
       tempNumberCaloriesPerCup = scnr.nextInt();
       
       // calculate number of cups
       tempNumberCups = calculateNumberCups(tempIngredientAmount, tempUnitOfMeasurement);
       
       // calculate total calories
       tempTotalCalories = tempNumberCups * tempNumberCaloriesPerCup;
       
       System.out.println(tempNameOfIngredient + " uses " + tempIngredientAmount 
                 + " " + tempUnitOfMeasurement + " and has " + tempTotalCalories + 
                " calories.");

       
       Ingredient tempNewIngredient = 
               new Ingredient(tempNameOfIngredient, tempUnitOfMeasurement,
                       tempIngredientAmount, tempNumberCaloriesPerCup, tempTotalCalories);
        return tempNewIngredient;
    }
    
    /**
     * print ingredient
     */
    public void printIngredient() {
        System.out.print(ingredientAmount + unitOfMeasurement);
        System.out.println(" " + nameOfIngredient);
    }
}


