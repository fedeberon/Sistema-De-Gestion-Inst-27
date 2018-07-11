package com.instituto27.controller.carreras;

import com.instituto27.domain.carrera.Carrera;
import com.instituto27.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.instituto27.service.carreras.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by ISFDyT Nº 27 on 30/05/2018.
 */
@Component
public class CarreraController {
    @FXML
    public TextField tfTurno;
    @FXML
    public TextField tfNombre;
    @Autowired
    public CarreraService carreraService;
    @FXML
    public ComboBox boxTurno;

    public void initialize() {
        boxTurno.getItems().removeAll(boxTurno.getItems());
        boxTurno.getItems().addAll("Mañana", "Tarde", "Noche");
        boxTurno.getSelectionModel().select("");
    }


    public void guardarCarrera(ActionEvent actionEvent) throws IOException {
        Carrera carrera = new Carrera();
        carrera.setNombre(tfNombre.getText());
        carrera.setTurno(boxTurno.getSelectionModel().getSelectedItem().toString());
        carreraService.save(carrera);
        }


    }



