package vistas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Damian on 11/05/2018.
 */
public class InicioView extends Application {

        @Override
        public void start(Stage stage) {
            //Creating a Text object
            Text text = new Text();

            //Setting the text to be added.
            text.setText("Hello how are you");

            //setting the position of the text
            text.setX(50);
            text.setY(50);
            text.setStyle("-fx-color: yellow;");
            //Creating a Group object
            Group root = new Group(text);

            //Creating a scene object
            Scene scene = new Scene(root, 600, 300);
            scene.getStylesheets().add("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css");

            Text titulo = new Text("Sample Application");

            titulo.setStyle("-fx-height: 200px");

            //Setting title to the Stage
            stage.setTitle("Sample Application");

            //Adding scene to the stage
            stage.setScene(scene);

            //Displaying the contents of the stage
            stage.show();
        }
        public static void main(String args[]){
            launch(args);
        }

    }