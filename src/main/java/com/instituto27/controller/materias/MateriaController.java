package com.instituto27.controller.materias;


import com.instituto27.domain.Materia;
import com.instituto27.domain.Profesor;
import com.instituto27.domain.carrera.Carrera;
import com.instituto27.main.Main;
import com.instituto27.service.carreras.CarreraService;
import com.instituto27.service.materia.MateriaService;
import com.instituto27.service.profesor.ProfesorService;
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

import java.util.List;


/**
 * Created by 12012018 on 07/06/2018.
 */
@Component
public class MateriaController {

    @FXML
    public Button btnCrearCarrera;

    @FXML
    public Button btnCrearProfesor;

    @FXML
    public TextField txtNombre;

    @FXML
    public Button btnGuardar;

    @FXML
    public ComboBox<Carrera> cmbCarreras;

    @FXML
    public ComboBox<Profesor> cmbProfesor;

    @FXML
    public ComboBox<String> cmbPlandeEstudio;

    @Autowired
    private MateriaService materiaService;

    @Autowired
    public CarreraService carreraService;

    @Autowired
    public ProfesorService profesorService;


    public void initialize() {
        cmbCarreras.setItems(getCarreraEnseignant());
        cmbProfesor.setItems(getProfesorEnseignant());
        cmbPlandeEstudio.setItems(PlandeEstudio);
    }

    public void crearCarrera(ActionEvent actionEvent) throws IOException {
        Node[] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = FXMLLoader.load(getClass().getResource("/fxml/carreras/create.fxml"));
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(nodes[v]);
    }

    public void ingresarProfesor(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/profesor/Profesor.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void btnGuardar(ActionEvent actionEvent) throws IOException {
        Materia materia = new Materia();
        materia.setNombre(txtNombre.getText());
        materia.setProfesor(cmbProfesor.getSelectionModel().getSelectedItem().toString());
        materia.setCarrera(cmbCarreras.getSelectionModel().getSelectedItem());
        materiaService.save(materia);

    }

    public ObservableList<Carrera> getCarreraEnseignant() {
        ObservableList<Carrera> enseignantList = FXCollections.observableArrayList();
        List<Carrera> eList = carreraService.findAll();
        for (Carrera ent : eList) {
            enseignantList.add(ent);
        }
        return enseignantList;
    }

    public ObservableList<Profesor> getProfesorEnseignant() {
        ObservableList<Profesor> enseignantList = FXCollections.observableArrayList();
        List<Profesor> eList = profesorService.findAll();
        for (Profesor ent : eList) {
            enseignantList.add(ent);
        }
        return enseignantList;
    }



    public ObservableList<String> PlandeEstudio = FXCollections.observableArrayList("Default");


}

