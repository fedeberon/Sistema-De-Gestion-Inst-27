package com.instituto27.controller.notas;


import com.instituto27.domain.Alumno;
import com.instituto27.domain.Nota;
import com.instituto27.domain.carrera.Carrera;
import com.instituto27.main.Main;
import com.instituto27.service.alumno.AlumnoService;
import com.instituto27.service.carreras.CarreraService;
import com.instituto27.service.nota.NotaService;
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

@Component
public class NotaController implements Initializable {

    @FXML
    public ComboBox<Carrera> cmbCarrera;

    @FXML
    public Button btnCrearCarrera;

    @FXML
    public ComboBox<String> cmbMateria;

    @FXML
    public Button btnCrearMateria;

    @FXML
    public ComboBox<Alumno> cmbAlumno;

    @FXML
    public Button btnCrearAlumno;

    @FXML
    public TextField campoNota;

    @FXML
    public Button btnGuardar;

    @Autowired
    public NotaService notaService ;

    @Autowired
    private CarreraService carreraService;

    @Autowired
    private AlumnoService alumnoService;

    /* IR AL MÓDULO DE CARRERAS */
    public void crearCarrera(ActionEvent actionEvent) throws IOException {
        Node[] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = FXMLLoader.load(getClass().getResource("/fxml/carreras/create.fxml"));
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(nodes[v]);
    }

    /* TRAER LA LISTA DE CARRERAS AL COMBOBOX */
    public void cargarComboDeCarreras() {
        ObservableList<Carrera> enseignantList = FXCollections.observableArrayList();
        List<Carrera> carreras = carreraService.findAll();
        for (Carrera ent : carreras) {
            enseignantList.add(ent);
        }

        if(enseignantList.size() != 0){
            cmbCarrera.setItems(enseignantList);
        }
    }

    /* IR AL MÓDULO DE MATERIAS */
    public void crearMateria(ActionEvent actionEvent) throws IOException {
        Node[] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = FXMLLoader.load(getClass().getResource("/fxml/materias/Materias.fxml"));
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(nodes[v]);
    }

    /* TRAER LA LISTA DE ALUMNOS AL COMBOBOX */
    public void cargarComboDeAlumnos() {
        ObservableList<Alumno> enseignantList = FXCollections.observableArrayList();
        List<Alumno> alumnos = alumnoService.findAll();
        for (Alumno ent : alumnos) {
            enseignantList.add(ent);
        }

        if(enseignantList.size() != 0){
            cmbAlumno.setItems(enseignantList);
        }
    }

    /* IR AL MÓDULO DE ALUMNOS */
    public void crearAlumno(ActionEvent actionEvent) throws IOException {
        Node[] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = FXMLLoader.load(getClass().getResource("/fxml/alumno/create.fxml"));
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(nodes[v]);
    }

    /* IR A LA INTERFAZ DE LISTA DE NOTAS */
    public void listaNotas(ActionEvent actionEvent) throws IOException {
        Node[] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = FXMLLoader.load(getClass().getResource("/fxml/notas/listaNotas.fxml"));
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(nodes[v]);
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.cargarComboDeCarreras();
        this.cargarComboDeAlumnos();
    }

    public void guardar(ActionEvent actionEvent) throws IOException {
         Nota nota = new Nota();
         nota.setNota(campoNota.getText());

        notaService.save(nota);
    }


}
