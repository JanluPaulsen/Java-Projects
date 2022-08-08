package question.pkg5;

import javafx.application.Application;//imports libraries
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Question5 extends Application {
   
    @Override
    public void start(Stage primaryStage) {
      Sphere bloueSph = new Sphere();//creates the sphere
      bloueSph.setRadius(100.0f);//sets the radius
      bloueSph.setTranslateX(120);//positions it
      bloueSph.setTranslateY(150);
      PhongMaterial blue = new PhongMaterial();//create material
      blue.setDiffuseColor(Color.BLUE);//set material color
      bloueSph.setMaterial(blue);//set sphere to material
      
      Sphere orangeSph = new Sphere();
      orangeSph.setRadius(100.0f);
      orangeSph.setTranslateX(400);
      orangeSph.setTranslateY(150);
      PhongMaterial orange = new PhongMaterial();//create material
      orange.setDiffuseColor(Color.ORANGE);//set material color
      orangeSph.setMaterial(orange);//set sphere to material
      
      
      
      Group root = new Group();//groups
      root.getChildren().add(bloueSph);//groups sphere
      root.getChildren().add(orangeSph);//groups sphere

        
        Scene scene = new Scene(root, 600, 300);//scene
        
        primaryStage.setTitle("3D Shapes drawing app");//sets title
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
