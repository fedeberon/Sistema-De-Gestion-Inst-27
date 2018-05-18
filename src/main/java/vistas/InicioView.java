package vistas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InicioView extends Application {

        @Override
        public void start(Stage stage) {
            //Creating a Text object
            Text text = new Text();

            //Titulo de  la ventana
            text.setText("Sistema De Gestion Instituto 27");

            //Posicion del titulo
            text.setX(500);
            text.setY(50);


            text.setStyle("-fx-color: yellow;");
            //Text edit
            text.setFont(new Font("Lucida Grande",24));
            text.setFill(Color.BLACK);

            //Creating a Group object
            Group root = new Group(text);

            //Creating a scene object
            Scene scene = new Scene(root, 1280, 768);
            scene.getStylesheets().add("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css");

            //Setting title to the Stage
            stage.setTitle("Instituto 27");

            //Adding scene to the stage
            stage.setScene(scene);

            //Displaying the contents of the stage
            stage.show();

            //Declaracion de objetos
            Button btnAlu = new Button();
            Button btnPro = new Button();
            Button btnMat = new Button();
            Button btnCar = new Button();

            btnAlu.setText("Alumnos");

            //Añadir elemento a la ventana (this.add en java swing)
            root.getChildren().add(btnAlu);
                      



            btnAlu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                }
            });



        }















        public static void main(String args[]){
            launch(args);
        }

    }
