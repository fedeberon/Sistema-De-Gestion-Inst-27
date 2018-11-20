package com.instituto27.controller.notas;

import com.instituto27.domain.Alumno;
import com.instituto27.domain.Materia;
import com.instituto27.domain.Nota;
import com.instituto27.domain.carrera.Carrera;
import com.instituto27.main.Main;
import com.instituto27.service.nota.NotaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;


public class NotaListaController {

    @FXML
    public Button btnCrearNota;

    @FXML
    public Button btnEliminarNota;

    @FXML
    public TableView tablaNotas;

    @FXML
    public TableColumn colID;

    @FXML
    public TableColumn colCarrera;

    @FXML
    public TableColumn colMateria;

    @FXML
    public TableColumn colAlumno;

    @FXML
    public TableColumn colNota;

    @Autowired
    public NotaService notaService;

    @Autowired
    public NotaController notaController;

    @Autowired
    public SessionFactory sessionFactory;

    /*
    public void initialize(){
        colID.setCellValueFactory(new PropertyValueFactory<Nota, Integer>("carrera"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<Nota, String>("carrera"));
        colMateria.setCellValueFactory(new PropertyValueFactory<Nota, String>("materia"));
        colAlumno.setCellValueFactory(new PropertyValueFactory<Nota, String>("alumno"));
        colNota.setCellValueFactory(new PropertyValueFactory<Nota, Integer>("nota"));
        tablaNotas.setItems(obtenerNotas());
    }

    public ObservableList<Nota> obtenerNotas() {
        ObservableList<Nota> enseignantList = FXCollections.observableArrayList();
        List<Nota> notas = notaService.findAll();
        for (Nota ent : notas) {
            enseignantList.add(ent);
        }

        return enseignantList;
    }*/

    /*IR A LA INTERFAZ DE CARGAR NOTA */
    public void crearNota(ActionEvent actionEvent) throws IOException {
        Node[] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = FXMLLoader.load(getClass().getResource("/fxml/notas/Notas.fxml"));
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(nodes[v]);
    }

}