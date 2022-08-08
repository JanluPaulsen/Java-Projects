package bmicalculator;

//Janlu Paulsen S3DMVCPL2

import javafx.application.Application; //import packages
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import java.sql.*;
import javafx.scene.control.Alert.AlertType;

public class BMICalculator extends Application { //declares enw class
    //declared globally to make accessing it faster
    String dbURL = "jdbc:mysql://localhost/hospital"; //url to conenct to the database
    String username = "root";//useranme to conenct to the database
    String password = "";//username to conenct to the database
    String driver = "com.mysql.cj.jdbc.Driver";//driver to conenct to the database
    @Override//overrides the method
    public void start(Stage primaryStage) {//new method
        Text patIDq = new Text(); //creates a new text
        patIDq.setText("Patient_ID"); //sets the text
        patIDq.setTranslateY(10);//moves is accoding to the translation
        TextField patIDa = new TextField();//creates a new textfield
        patIDa.setPrefHeight(32);//sets the height
        Text nameq = new Text();//creates a new text
        nameq.setText("Name");//sets the text
        nameq.setTranslateY(26);//moves is accoding to the translation
        TextField namea = new TextField();//creates a new textfield
        namea.setPrefHeight(32);//sets the height
        Text genderq = new Text();//creates a new text
        genderq.setText("Gender");//sets the text
        genderq.setTranslateY(42);//moves is accoding to the translation
        TextField gendera = new TextField();//creates a new textfield
        gendera.setPrefHeight(32);//sets the height
        RadioButton male1 = new RadioButton();//creates a new radiobutton
        male1.setText("Male");//sets the text
        male1.setTranslateY(48);//moves is accoding to the translation
        male1.setPrefHeight(32);//sets the height
        male1.setPrefWidth(155);//sets the width
        male1.setStyle("-fx-background-color: WHITE;");//sets the background to the color white
        RadioButton male2 = new RadioButton();//creates a new radiobutton
        male2.setText("Female");//sets the text
        male2.setPrefHeight(32);//sets the height
        male2.setPrefWidth(155);//sets the width
        male2.setStyle("-fx-font-weight: bold");//sets the font style to bold
        male2.setStyle("-fx-background-color: WHITE;");//sets the background to the color white
        Text kgq = new Text();//creates a new text
        kgq.setText("Weight in Kg");//sets the text
        kgq.setTranslateY(57);//moves is accoding to the translation
        TextField kga = new TextField();//creates a new textfield
        kga.setPrefHeight(32);//sets the height
        Text heightq = new Text();//creates a new text
        heightq.setText("Height in meters");//sets the text
        heightq.setTranslateY(73);//moves is accoding to the translation
        TextField heighta = new TextField();//creates a new textfield
        heighta.setPrefHeight(32);//sets the height
        Text messageq = new Text();//creates a new text
        messageq.setText("Message");//sets the text
        messageq.setTranslateY(89);//moves is accoding to the translation
        TextField messagea = new TextField();//creates a new textfield
        messagea.setPrefHeight(32);//sets the height
        Button calBMI = new Button();//creates a new button
        calBMI.setPrefWidth(157);//sets the width
        calBMI.setPrefHeight(32);//sets the height
        calBMI.setTranslateY(96);//moves is accoding to the translation
        Button display = new Button();//creates a new button
        display.setPrefWidth(157);//sets the width
        display.setPrefHeight(32);//sets the height
        calBMI.setText("Calculate BMI");//sets the text
        display.setText("Display");//sets the text
        calBMI.setOnAction(new EventHandler<ActionEvent>() {//new event handler for the button "calBMI"
            @Override//overrides the method
            public void handle(ActionEvent event) {//new method
                    System.out.println("Calculate BMI");//prints to console
                    String dbPatIDa = patIDa.getText();//gets text from the textfield and stores it in the string
                    String genderCal = gendera.getText();//gets text from the textfield and stores it in the string
                    int weight = Integer.parseInt(kga.getText());//gets integer from the textfield and stores it in the integer
                    double height = Double.parseDouble(heighta.getText());//gets integer from the textfield and stores it in the double
                    double heightTotal = height*height;//gets integer from the textfield and stores it in the double
                    float BMI = (float) ((float)weight/heightTotal);//calculates a float and forcing flaot onto the other variables
                    System.out.println(BMI);//prints to console
                    Alert alertBMI = new Alert(AlertType.INFORMATION);//creates a pop up
                    alertBMI.setTitle("Message");//name of the pop up
                    alertBMI.setHeaderText("You BMI is: " + BMI);//display message on pop up
                    alertBMI.show();//shows the pop up
                    try{//try catch
                    dbPatIDa = patIDa.getText();//gets text from the textfield and stores it in the string
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver to connect to database
                    Connection connect = DriverManager.getConnection(dbURL, username, password);//conenct to the database
                    Statement s = connect.createStatement();//create statement for connect
                    String query = "INSERT INTO `bmi progress`(Patient_ID, BMI)" + " VALUES ('" + dbPatIDa + "', '" + (Math.round(BMI * 100.0)/100.0) + "')";//sql query command
                    System.out.println(query);//prints it to the console
                    s.execute(query);//executes the sql query command
                connect.close();//closes the connect to the db
                } catch (Exception e) {//try catch with exception
                System.out.println("Error connection db");//prints to console
                e.printStackTrace();//prints error
                }
                    if("Male".equals(genderCal) && BMI < 22.5){ //these if and else if statements are to determine wether that are male or female
                        //as well as specify which text should be set and displayed
                        messagea.setText("You are underweight.");
                    }
                    else if("Male".equals(genderCal) && BMI > 22.5 && BMI < 29.5){
                        messagea.setText("You are ideal weight.");
                    }
                    else if("Male".equals(genderCal) && BMI > 29.5 && BMI < 32.9){
                        messagea.setText("You are overweight.");
                    }
                    else if("Male".equals(genderCal) && BMI > 33){
                        messagea.setText("You are obese.");
                    }
                    else if("Female".equals(genderCal) && BMI < 18.5){
                        messagea.setText("You are underweight.");
                    }
                    else if("Female".equals(genderCal) && BMI > 18.5 && BMI < 24.5){
                        messagea.setText("You are ideal weight.");
                    }
                    else if("Female".equals(genderCal) && BMI > 24.5 && BMI < 29.9){
                        messagea.setText("You are overweight.");
                    }
                    else if("Female".equals(genderCal) && BMI > 30){
                        messagea.setText("You are obese.");
                    }
                }
        });
        display.setOnAction(new EventHandler<ActionEvent>() {//new event handler for the button "display"
            @Override//overrides the method
            public void handle(ActionEvent event) {//new method
                String dbPatIDa;//creates new string
                String dbGendera;//creates new string
                Alert alertInfo = new Alert(AlertType.INFORMATION);//creates new alert
                alertInfo.setTitle("Message");//name of alert
                alertInfo.setHeaderText("The patient's record was successfully displayed!");//messages displayed in alert
                alertInfo.show();//shows the alert
                try{//try catch
                    dbPatIDa = patIDa.getText();//gets the text from the textfield and stores it in a string
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver to connect ot database
                    Connection connect = DriverManager.getConnection(dbURL, username, password);//connection to database(db)
                    Statement statemt = connect.createStatement();//statement for the conenction
                    
                    //below is the code for the database
        
                    //creates database
                    String sqlCreateDB = "CREATE DATABASE hospital";
        
                    //creates table
                    String sqlCreateTable = "CREATE TABLE PATIENT" +
                            "(Patient_ID INTEGER not NULL,"+
                            "Name VARCHAR(255),"+
                            "Gender VARCHAR(6),"+
                            "Weight INTEGER,"+
                            "Height DOUBLE,"+
                            "PRIMARY KEY (Patient_ID))";
                    //statements
                    //statemt.executeUpdate(sqlCreateDB);
                    //statemt.executeUpdate(sqlCreateTable);
                    
                    
                    ResultSet resultSet = statemt.executeQuery("SELECT * FROM patient WHERE Patient_ID = " + dbPatIDa);//sql query command
                    while(resultSet.next()){//while loop with the condition as long as there is something next to read
                    System.out.println("Display");//displayes in console
                    namea.setText(resultSet.getString("Name"));//gets the names from the db(database)
                    dbGendera = resultSet.getString("Gender");//gets the gender from the db(database)
                    gendera.setText(dbGendera);//sets the string to the gender/ used in line 154
                    kga.setText(resultSet.getString("Weight"));//gets the Weight from the db(database)
                    heighta.setText(resultSet.getString("Height"));//gets the Height from the db(database)
                    if ("Male".equals(dbGendera)) {//when gender is selected the if and else is used to determine which gender it is
                        //and then set the radiobuttons accordingly so that only one is displayed at a time

                            male1.setSelected(true);
                            male2.setSelected(false);
                        } else {
                            male1.setSelected(false);
                            male2.setSelected(true);
                        }
                }
                connect.close();//closes the connection
                } catch (Exception e) {//try catch exception
                System.out.println("Error connection db");//prints to console
                e.printStackTrace();//prints error to console
                }
            }
        });
        
        
        VBox cL1 = new VBox(); //creates new VBox
        cL1.setStyle("-fx-font-weight: bold");//sets the dont stule all to bold
        cL1.getChildren().add(patIDq);//adds all the components
        cL1.getChildren().add(nameq);
        cL1.getChildren().add(genderq);
        cL1.getChildren().add(male1);
        cL1.getChildren().add(kgq);
        cL1.getChildren().add(heightq);
        cL1.getChildren().add(messageq);
        cL1.getChildren().add(calBMI);
        
        VBox cL2 = new VBox();//creates new VBox
        cL2.getChildren().add(patIDa);//adds all the components
        cL2.getChildren().add(namea);
        cL2.getChildren().add(gendera);
        cL2.getChildren().add(male2);
        cL2.getChildren().add(kga);
        cL2.getChildren().add(heighta);
        cL2.getChildren().add(messagea);
        cL2.getChildren().add(display);
        
        
        HBox order = new HBox(); //creates a new HBox
        order.getChildren().add(cL1);//ads the prevoous VBoxes
        order.getChildren().add(cL2);
        
        
        BackgroundFill background_fill = new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY); //this sets the code of the background
        Background background = new Background(background_fill);
        order.setBackground(background);
        
        Scene scene = new Scene(order, 307, 260);//sets the size of the application window
        
        primaryStage.setTitle("Patient BMI Calculator");//sets the name of the application
        primaryStage.setScene(scene); //sets the scene
        primaryStage.show();//shows the scene
    }

    public static void main(String[] args) { //main method
        
        
        
        launch(args);//runs the javafx
    }    
    
}
