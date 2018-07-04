package com.instituto27.controller.alumnos;

import com.instituto27.domain.Alumno;
import com.instituto27.service.alumno.AlumnoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
/**
 * Created by ISFDyT Nº 27 on 30/05/2018.
 */

@Component
public class AlumnoController {

    @FXML
    public TextField aluNombre;

    @FXML
    public TextField aluApellido;

    @FXML
    public TextField aluDni;

    @FXML
    public DatePicker aluFecNac;

    @FXML
    public TextField aluCelular;

    @FXML
    public TextField aluDireccion;

    @FXML
    public TextField aluEmail;

    @Autowired
    private AlumnoService alumnoService;


    public void save(ActionEvent actionEvent) throws IOException {
        Alumno alumno = new Alumno();

        alumno.setNombre(aluNombre.getText());
        alumno.setApellido(aluApellido.getText());
        alumno.setDNI(aluDni.getText());
        alumno.setCelular(aluCelular.getText());
        alumno.setDireccion(aluDireccion.getText());
        alumno.setEmail(aluEmail.getText());
        alumno.setFechaNacimiento(aluFecNac.getValue());

        alumnoService.save(alumno);


//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("/fxml/menu/.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = new Stage();
//
//        stage.setScene(scene);
//        stage.show();
//        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }
}

