package com.instituto27.controller.carreras;

import com.instituto27.domain.carrera.Carrera;
import com.instituto27.service.carreras.CarreraService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by ISFDyT Nº 27 on 13/07/2018.
 */
@Component
public class CarreraController {
    //Elements from list.fxml
    @FXML
    public TableView<Carrera> listCarreras;
    @FXML
    public TableColumn colNom;
    @FXML
    public TableColumn colTur;

    @Autowired
    public CarreraService carreraService;
    @Autowired
    public CarreraMenuController carreraMenuController;
    @Autowired
    public CarreraFormController carreraFormController;
    @Autowired
    public SessionFactory sessionFactory;

    public void initialize(){
        colNom.setCellValueFactory(new PropertyValueFactory<Carrera, String>("nombre"));
        colTur.setCellValueFactory(new PropertyValueFactory<Carrera, String>("turno"));
        listCarreras.setItems(getEnseignant());
    }
    //Trae lista de carreras de la base de datos
    public ObservableList<Carrera> getEnseignant() {
        ObservableList<Carrera> enseignantList = FXCollections.observableArrayList();
        List<Carrera> eList = carreraService.findAll();
        for (Carrera ent : eList) {
            enseignantList.add(ent);
        }
        return enseignantList;
    }
    //Al presionar el boton "Crear nueva carrera" en la seccion lista, te redirecciona a "/fxml/carreras/create.fxml"
    public void guardarCarrera(ActionEvent actionEvent) throws IOException {
        carreraMenuController.crearCarrera(actionEvent);
    }
    //Al presionar "Atras" en la seccion lista, te redirecciona a "/fxml/carreras/home.fxml"
    public void atrasHome(ActionEvent actionEvent) throws IOException {
        carreraFormController.atrasHome(actionEvent);
    }
    //Elimina todos los registros de la tabla y la base de datos
    public void borrarCarrera(ActionEvent actionEvent) {
        Carrera carrera = listCarreras.getSelectionModel().getSelectedItem();
        listCarreras.getItems().remove(carrera);
        carreraService.delete(carrera);
    }
}
