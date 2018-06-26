package controller.alumnos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

/**
 * Created by ISFDyT Nº 27 on 30/05/2018.
 */

@Controller
public class AlumnoController {

    @FXML
    public Label labelHolaMundo;

    @FXML
    public TextField textNombre;

    @FXML
    public Button botonGuardar;

    @FXML
    ComboBox<String> comboBoxSexo = new ComboBox<String>();

    public void cargarAlumno(ActionEvent actionEvent) {

    }


//    public void btnAlumnos(ActionEvent actionEvent) {
//
//        System.out.print("Se ingreso " + textNombre.getText());
//
//    }
//
//
//    public void guardar(ActionEvent actionEvent) {
//        System.out.print("Se ingreso " + textNombre.getText());
//
//    }
}
