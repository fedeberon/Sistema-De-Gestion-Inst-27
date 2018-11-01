package com.instituto27.controller.alumnos;

import com.instituto27.domain.Alumno;
import com.instituto27.main.Main;
import com.instituto27.service.alumno.AlumnoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by ISFDyT Nº 27 on 06/07/2018.
 */
@Component
public class MenuAlumnoController {

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


    public void buscarAlumnos(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/alumno/show.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void cargarAlumnos(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/alumno/create.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void createAtras(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/alumno/home.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

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
    }
}
