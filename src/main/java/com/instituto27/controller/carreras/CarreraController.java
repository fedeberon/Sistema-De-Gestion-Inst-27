package com.instituto27.controller.carreras;

import com.instituto27.domain.carrera.Carrera;
import com.instituto27.service.carreras.CarreraService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ISFDyT Nº 27 on 13/07/2018.
 */
@Component
public class CarreraController {
    @Autowired
    public CarreraService carreraService;

    public void initialize(){
        colNom.setCellValueFactory(new PropertyValueFactory<Carrera, String>("nombre"));
        colTur.setCellValueFactory(new PropertyValueFactory<Carrera, String>("turno"));
        listCarreras.setItems(getEnseignant());
    }

    public ObservableList<Carrera> getEnseignant() {
        ObservableList<Carrera> enseignantList = FXCollections.observableArrayList();
        List<Carrera> eList = carreraService.findAll();
        for (Carrera ent : eList) {
            enseignantList.add(ent);
        }
        return enseignantList;
    }

    @FXML
    public TableView<Carrera> listCarreras;
    @FXML
    public TableColumn colNom;
    @FXML
    public TableColumn colTur;
}
