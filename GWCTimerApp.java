package gwctimerapp;

//Janlu Paulsen S3DMVCPL2

import javafx.application.Application; //import packages
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GWCTimerApp extends Application { //declares a new class
    long timeAmount = 0; //new global variable
    Boolean timerStarted = false;//new global variable
    @Override//overrides the method
    public void start(Stage primaryStage) { //new method declared
        Button startBtn = new Button(); //new button declared
        Button stopBtn = new Button();//new button declared
        Label timeLabel = new Label("Time (in seconds)");//new label declared
        TextField time = new TextField();//new textfield declared
        time.setEditable(false);//sets it so the textfield is not editable
        startBtn.setText("Start Timer");//sets the text of the button
        stopBtn.setText("Stop Timer");//sets the text of the button
        Thread timer = new Thread(new Runnable(){ //declares a new thread
            @Override//overrides the method
            public void run(){//new method
                try{//try catch
                    while(timerStarted = true){ //while loop with the condition the boolean is true it will execute
                        String displayTimer = String.valueOf(timeAmount);//creates a string of the int
                        Thread.sleep(1000);//tells the thread to sleep for one second and then
                        timeAmount++;//it adds one to the integer after the thread has slept for one second
                        System.out.println(displayTimer);//prints the integer timeamount to the console
                        time.setText(displayTimer);//sets the text of the textfield to the seconds
                    }
                }catch(InterruptedException e){//try catch, any errors to do with interrupted
                    e.printStackTrace();//prints out the spesific error
                }
            }
        });
        startBtn.setOnAction(new EventHandler<ActionEvent>() {//button eventhandler
            @Override//overides the method
            public void handle(ActionEvent event) {//code that works with the button
                if(timerStarted){//if the conditon is true
                    timer.resume();//if the button was clicked after it started and the timer was paused it will resume the counting
                    System.out.println("Timer Started"); //prints to console timer has started
                }
                else{
                    System.out.println("Timer Started");//prints to console timer has started
                    timer.start();//when the start button was clicked first it start counting
                    timerStarted = true; //when button is click it sets the boolean to true
                }
            }
        });
        stopBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Timer Stopped");//prints to console to say button has been stopped/paused
                timer.suspend();//pauses the button
            }
        });
        HBox label = new HBox(); //declares a new HBox
        label.setSpacing(5); //sets the spacing between the labels
        label.getChildren().add(timeLabel); //gets the "timeLabel"
        label.getChildren().add(time);//gets the "time" textfield
        HBox btnTimer = new HBox(); //new HBox
        btnTimer.setTranslateY(35);//moves the HBox down
        btnTimer.setSpacing(10);//sets the spacing
        btnTimer.getChildren().add(startBtn);//adds the start button
        btnTimer.getChildren().add(stopBtn);//adds the stop button
        Group sceneFinal = new Group(btnTimer,label);//groups the HBox
        Scene scene = new Scene(sceneFinal, 300, 75);//setst the scene
        primaryStage.setTitle("GWC Timer App");//sets the title of the app
        primaryStage.setScene(scene);//sets the scene
        primaryStage.show();//shows the scene
    }
    public static void main(String[] args) {//main method
        launch(args);//launches everything
    }
}
