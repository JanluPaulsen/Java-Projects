//@author Janlu Paulsen S3DMVCPL2
//Question 2 PropertiesGame
package propertiesgame;

import java.util.Scanner;
import java.util.InputMismatchException;

public class PropertiesGame {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        int houseVal = 700_000;
        int flatVal = 150_000;
        int duplexVal = 300_000;
        int loftVal = 180_000;
        int userCapi = 0;
        int amountSpent = 0;
        int mainSwitchController = 1;
        int buyAmount;
        boolean restart = true;
        
        System.out.println("Welcome to Properties Game. A game where "
                + "you can buy properties");
        System.out.println("Here is a list of all the properties you can buy.");
        
        System.out.println("|Property    |Price     |");
        System.out.println("|House       |R700 000  |");
        System.out.println("|Flat        |R150 000  |");
        System.out.println("|Duplex      |R300 000  |");
        System.out.println("|Loft        |R180 000  |");
        
        System.out.println("Just enter you capital that you "
                + "have and we can start.");
        
        
        while (restart){
            try{
               System.out.print("R: ");
               userCapi = userInput.nextInt();
               restart = false;
            }
            catch (InputMismatchException e){
                userInput.next();
                System.out.println("Please enter a valid number");
            }
        }
        
        System.out.println("R: " + userCapi);
        
        System.out.println("To buy a property just simply enter the "
                + "value of the property.");
        System.out.println("When you are done buying "
                + "just type 0 to end the game.");
        System.out.println("Your current capital is R: " + userCapi);
        
        do{
            try{
                switch(buyAmount = userInput.nextInt()){
                    case 700_000:
                        System.out.println("You bought house.");
                        userCapi = userCapi - houseVal;
                        amountSpent = amountSpent + 700_000;
                        break;
                    case 150_000:
                        System.out.println("You bought flat.");
                        userCapi = userCapi - flatVal;
                        amountSpent = amountSpent + 150_000;
                        break;
                    case 300_000:
                        System.out.println("You bought duplex.");
                        userCapi = userCapi - duplexVal;
                        amountSpent = amountSpent + 300_000;
                        break;
                    case 180_000:
                        System.out.println("You bought loft.");
                        userCapi = userCapi - loftVal;
                        amountSpent = amountSpent + 180_000;
                        break;
                    case 0:
                        mainSwitchController = 0;
                    default:
                        if (buyAmount > 0){
                            System.out.println("Please enter a valid number.");
                        }
                        else{
                            break;
                        }
                }
            }
            catch(InputMismatchException e){
                System.out.println("Please enter a valid number");
                mainSwitchController = 1;
                userInput.next();
            }
        } while (mainSwitchController != 0);
        
        if (mainSwitchController == 0 && userCapi >= 0 && amountSpent < 500_000){
            System.out.println("Thank you for playing.");
            System.out.println("Your change is R: " + userCapi);
        }
        else if(mainSwitchController == 0 && userCapi >= 0 && amountSpent > 499_999){
            double discountedOutput = userCapi + (amountSpent * 0.15);
            System.out.println("Thank you for playing.");
            System.out.println("Your change is R: " + discountedOutput);
        }
        else if (mainSwitchController == 0 && userCapi < 0 && amountSpent < 500_000){
            System.out.println("Thank you for playing.");
            System.out.println("Your owe R: " + userCapi);
        }
        else if(mainSwitchController == 0 && userCapi < 0 && amountSpent > 499_999){
            double discountedOutput = userCapi + (amountSpent * 0.15);
            System.out.println("Thank you for playing.");
            System.out.println("Your owe R: " + discountedOutput);
        }
    }
    
}
