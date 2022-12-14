package medicine;
import java.util.*; //imports all packages relevant
import java.io.*;

//Janlu Paulsen S3DMVCPL2

public class Medicine {
        public static void main(String[] args) {
            HashSet<String> medicineDetails = new HashSet<String>(); //this declares a new hashset
            try{ //error handling to run the code and if there is error a carch code wil execute
                File medicine = new File("medicines.txt"); //creatures a new file
                Scanner readFile = new Scanner(medicine); //this will be used to read the file
                while(readFile.hasNextLine()){//loop to keep executing the code as long as there is text in the file
                    String data = readFile.nextLine().replace(",", " "); //creates a new string but also replaces any occurrences of a comma
                    int len = data.length(); //gets length of a line
                    int first = data.lastIndexOf("R"); //gets the index(position) of the last occurrences of the letter R
                    String temp = data.substring(first, len); //creates a string that will temporarily store a substring
                    //first is to say to replace something at the position where len is used to say to start look for a spesific character starting at a spesific position
                    temp = temp.replace("R", "");//replaces R in the temp string
                    data = data.replace(data.substring(first, len), temp); //stores the temp string into the main string
                    medicineDetails.add(data); //adds the string to the hashset
                }
                readFile.close(); //closes the file after the loop is done
            }catch (FileNotFoundException e){ //executes the code that displays a error message
                System.out.println("Error"); //prints out "Error" to the console
                e.printStackTrace();//handles errors
            }
        Iterator finalCheck = medicineDetails.iterator(); //iterator used to read each string one by one from the hashset and store it
        System.out.println("Medirite Medicines:"); //prints to console
        System.out.println("ID Name Type Manufacturer Price"); //prints to console
        while (finalCheck.hasNext()) { //loop to make sure there is text
        System.out.println(finalCheck.next()); //prints it out to console
        }
    }
}