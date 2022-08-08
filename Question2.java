package question.pkg2;
import java.util.*; //imports all util packages

public class Question2 extends Thread { //declaring a class
    
    public static void main(String[] args) { //main method
        
        System.out.println("Give a letter between a to z"); //prints to the console
        Scanner in = new Scanner(System.in); //declares a scanner that is used to read from the console
        char c = in.nextLine().charAt(0); //declares a variable that takes a single character from the console(input from the user)
        
        Question2 firstThread = new Question2(); //declaring new thread
        Question2 secondThread = new Question2();//declaring new thread
        
        firstThread.primaryThread(c);//links to the 'firstThread' method
        secondThread.secondaryThread(c);//links to the 'secondThread' method
    }
    
    public void primaryThread(char c) {//declaring new method (calls the char variable from the main method)
    System.out.println("This code is running in a thread");//prints to the console
        int counter = 1;//declares a variable
        while(counter < 26){//loop that keeps running till the variable counter is no longer smaller than 26
            String displayedAmount = String.valueOf(c);//displays the variable
            counter++;//adds 1 to the counter
            System.out.println(displayedAmount);//prints to the console
        }
    }
    
    public void secondaryThread(char c) {//declaring new method (calls the char variable from the main method)
    System.out.println("This code is running in a thread");//prints to the console
        int counter = 1;//declares a variable
        ++c;//adds 1 to the variable but cause it then to display the next character in the alphabet/special characters
        while(counter < 26){//loop that keeps running till the variable counter is no longer smaller than 26
            String displayedAmount = String.valueOf(c);//displays the variable
            counter++;//adds 1 to the counter
            System.out.println(displayedAmount);//prints to the console
        }
    }
}
