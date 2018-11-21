package com.instituto27.controller.notas;


import com.instituto27.domain.Alumno;
import com.instituto27.domain.Materia;
import com.instituto27.domain.Nota;
import com.instituto27.domain.carrera.Carrera;
import com.instituto27.main.Main;
import com.instituto27.service.alumno.AlumnoService;
import com.instituto27.service.carreras.CarreraService;
import com.instituto27.service.materia.MateriaService;
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
    public ComboBox<Materia> cmbMateria;

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
    private NotaService notaService ;

    @Autowired
    private CarreraService carreraService;

    @Autowired
    private MateriaService materiaService;

    @Autowired
    private AlumnoService alumnoService;

    /* TRAER LA LISTA DE CARRERAS */
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

    /* IR A LA INTERFAZ DEL MÓDULO CARRERA */
    public void crearCarrera(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/carreras/create.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    /* TRAER LA LISTA DE MATERIAS */
    public void cargarComboDeMaterias() {
        ObservableList<Materia> enseignantList = FXCollections.observableArrayList();
        List<Materia> materias = materiaService.findAll();
        for (Materia ent : materias) {
            enseignantList.add(ent);
        }

        if(enseignantList.size() != 0){
            cmbMateria.setItems(enseignantList);
        }
    }

    /* IR A LA INTERFAZ DEL MÓDULO MATERIA */
    public void crearMateria(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/materias/Materias.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    /* TRAER LA LISTA DE ALUMNO */
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

    /* IR A LA INTERFAZ DEL MÓDULO ALUMNO */
    public void crearAlumno(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/alumno/create.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    /* GUARDAR EN LA TABLA NOTAS */
    public void guardar(ActionEvent actionEvent) throws IOException {
        Nota nota = new Nota();
        nota.setNota(campoNota.getText());
        nota.setCarrera(cmbCarrera.getValue());
        nota.setMateria(cmbMateria.getValue());
        nota.setAlumno(cmbAlumno.getValue());

        notaService.save(nota);
    }

    /* IR A LA INTERFAZ LISTA DE NOTAS */
    public void listaNotas(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/notas/listaNotas.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.cargarComboDeCarreras();
        this.cargarComboDeAlumnos();
        this.cargarComboDeMaterias();
    }

}