package com.instituto27.controller.carreras;

import com.instituto27.domain.carrera.Carrera;
import com.instituto27.main.Main;
import com.instituto27.service.carreras.CarreraService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ISFDyT Nº 27 on 02/10/2018.
 */
@Component
public class CarreraFormController implements Initializable {

    @FXML
    public TextField tfNombre;
    @FXML
    public ComboBox<String>boxTurno;
    @Autowired
    public CarreraService carreraService;
    @Autowired
    public CarreraMenuController carreraMenuController;

    public ObservableList<String> getList() {
        return list;
    }
    public void setList(ObservableList<String> list) {
        this.list = list;
    }

    //Elements from create.fxml
    //Se crean items en el ComboBox
    public ObservableList<String> list = FXCollections.observableArrayList("Mañana", "Tarde", "Noche");

    //Guarda el turno y el nombre de la carrera
    public void guardarCarrera(ActionEvent actionEvent) throws IOException {
        Carrera carrera = new Carrera();
        carrera.setNombre(tfNombre.getText());
        carrera.setTurno(boxTurno.getSelectionModel().getSelectedItem().toString());
        carreraService.save(carrera);
        carreraMenuController.listaCarreras(actionEvent);
    }
    //Regresa al menu principal del modulo carrera
    public void atrasHome(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/carreras/home.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boxTurno.setItems(list);
    }
}
