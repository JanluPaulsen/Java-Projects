package question.pkg1;
import java.util.*;//imports all util packages

public class Question1 {//declaring a class
    public static void main(String[] args) {//main method
        String names = "";//declares a variable
        int terminate = 0; //declares a variable(acts as a boolean)
        int terminate2 = 0;//declares a variable (acts as a boolean)
        System.out.println("Please enter names");//prints to console
        Scanner readInput = new Scanner(System.in); //declares a scanner that is used to read from the console
        Set<String> hashSet = new HashSet<String>(); //declares a new HashSet
        do{//starts a loop...
            names = readInput.nextLine();//reads the input from the console from the user
            if(!names.equals("done")){//if statement with the condition that when 'done' is typed in the console it will go to the else statement
                hashSet.add(names);//adds the input from the console to the HashSet
                terminate = 0; //does not change the varibale and continues the loop
            }
            else{//else statement used to change the terminate variable and end the program
                terminate = 1;//changes the variable to 1 cause the while condition to fail and ending the loop
            }
        }while (terminate !=1);//...that ends when the condition is not met
        System.out.println(hashSet);//prints the HashSet to the console
        do{//starts a loop...
            System.out.println("Are you looking for a spesific name? 'yes' to search 'no' to end the program");//prints to the console
            String decider = "";//declares a variable
            decider = readInput.nextLine();//reads the input from the console from the user
            if (decider.equals("yes")){//if statement with the condition that when 'yes' is typed in the console it will run some code and end the program
                System.out.println("Who are you looking for?");//prints to console
                System.out.println(hashSet.contains(readInput.nextLine()));//prints to console the spesific name that the user is looking for
                terminate2 = 1;//changes the variable to 1 cause the while condition to fail and ending the loop
            }
            else if(decider.equals("no")){
                System.out.println(hashSet);//prints to console
                terminate2 = 1;//changes the variable to 1 cause the while condition to fail and ending the loop
            }
            else{
                System.out.println("You made a typing mistake.");//prints to console and restarts the loop till the conditions are met
            }
        } while(terminate2 !=1);//...that ends when the condition is not met
    }
}
