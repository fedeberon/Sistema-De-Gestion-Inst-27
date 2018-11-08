package com.instituto27.controller.materias;


import com.instituto27.domain.Materia;
import com.instituto27.domain.carrera.Carrera;
import com.instituto27.main.Main;
import com.instituto27.service.carreras.CarreraService;
import com.instituto27.service.materia.MateriaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by 12012018 on 07/06/2018.
 */
@Component
public class MateriaController implements Initializable{

    @FXML
    public Button btnCrearCarrera;

    @FXML
    public TextField txtNombre;

    @FXML
    public TextField profesor;

    @FXML
    public Button btnGuardar;

    @FXML
    public ComboBox<Carrera> cmbCarreras;

    @Autowired
    MateriaService materiaService;

    @Autowired
    public CarreraService carreraService;

    public void crearCarrera(ActionEvent actionEvent) throws IOException {
        Node[] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = FXMLLoader.load(getClass().getResource("/fxml/carreras/create.fxml"));
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(nodes[v]);
    }

    public void btnGuardar(ActionEvent actionEvent) throws IOException {
        Materia materia = new Materia();
        materia.setNombre(txtNombre.getText());
        materia.setProfesor(profesor.getText());

        materiaService.save(materia);
    }

    public ObservableList<Carrera> getEnseignant() {
        ObservableList<Carrera> enseignantList = FXCollections.observableArrayList();
        List<Carrera> eList = carreraService.findAll();
        for (Carrera ent : eList) {
            enseignantList.add(ent);
        }
        return enseignantList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbCarreras.setItems(getEnseignant());
    }

}

