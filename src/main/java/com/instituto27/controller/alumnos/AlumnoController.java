package com.instituto27.controller.alumnos;

import com.instituto27.domain.Alumno;
import com.instituto27.domain.carrera.Carrera;
import com.instituto27.main.Main;
import com.instituto27.service.alumno.AlumnoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by ISFDyT Nº 27 on 30/05/2018.
 */

@Component
public class AlumnoController  implements Initializable {

    @Autowired
    private AlumnoService alumnoService;

    public void  initialize(URL url, ResourceBundle rb) {
        itemIdCol.setCellValueFactory(new PropertyValueFactory<Alumno,Integer>("id"));
        itemNameCol.setCellValueFactory(new PropertyValueFactory<Alumno,String>("nombre"));
        itemApeCol.setCellValueFactory(new PropertyValueFactory<Alumno,String>("apellido"));
        itemDNICol.setCellValueFactory(new PropertyValueFactory<Alumno,String>("DNI"));
        itemFechaDeNacimientoCol.setCellValueFactory(new PropertyValueFactory<Alumno,LocalDate>("fechaNacimiento"));
        itemCelularCol.setCellValueFactory(new PropertyValueFactory<Alumno,LocalDate>("celular"));
        itemDireccionCol.setCellValueFactory(new PropertyValueFactory<Alumno,LocalDate>("direccion"));
        itemEmailCol.setCellValueFactory(new PropertyValueFactory<Alumno,LocalDate>("email"));
        tablaAlumnos.setItems(getEnseignant());
    }

    public ObservableList<Alumno> getEnseignant() {
        ObservableList<Alumno> enseignantList = FXCollections.observableArrayList();
        List<Alumno> eList = alumnoService.findAll();
        for (Alumno ent : eList) {
            enseignantList.add(ent);
        }
        return enseignantList;
    }

    public void showAtras(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/alumno/home.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    //Elimina todos los registros de la tabla y la base de datos

    public void borrarAlumno(ActionEvent actionEvent) {
        Alumno alumno = tablaAlumnos.getSelectionModel().getSelectedItem();
        tablaAlumnos.getItems().remove(alumno);
        alumnoService.delete(alumno);
    }

    @FXML
    public TableView<Alumno> tablaAlumnos;
    @FXML
    public TableColumn itemIdCol;
    @FXML
    public TableColumn itemNameCol;
    @FXML
    public TableColumn itemApeCol;
    @FXML
    public TableColumn itemDNICol;
    @FXML
    public TableColumn itemFechaDeNacimientoCol;
    @FXML
    public TableColumn itemCelularCol;
    @FXML
    public TableColumn itemDireccionCol;
    @FXML
    public TableColumn itemEmailCol;

}

