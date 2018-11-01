package com.instituto27.controller.carreras;

import com.instituto27.main.Main;
import com.instituto27.service.carreras.CarreraService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ISFDyT Nº 27 on 30/05/2018.
 */
@Component
public class CarreraMenuController{

    @Autowired
    public CarreraService carreraService;
    @Autowired
    public CarreraFormController carreraFormController;
    //Elements from home.fxml
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

    //Obtiene y muestra el nombre de la carrera y el turno
    public void listaCarreras(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/carreras/list.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }
}





