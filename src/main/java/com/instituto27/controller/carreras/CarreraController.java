package com.instituto27.controller.carreras;

import com.instituto27.controller.DrapoDashboard;
import com.instituto27.domain.carrera.Carrera;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.instituto27.service.carreras.CarreraService;

import java.io.IOException;

/**
 * Created by ISFDyT Nº 27 on 30/05/2018.
 */
public class CarreraController {

    private CarreraService carreraService = new CarreraService();

    @FXML
    public TableView tablaCarrera = new TableView();

    public void guardarCarrera(ActionEvent actionEvent) throws IOException {
        Stage s = DrapoDashboard.getPrimaryStage();

        Node [] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = FXMLLoader.load(getClass().getResource("/fxml/carreras/list.fxml"));

        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(nodes[v]);
        pnl_scroll.setVisible(true);

//        tablaCarrera.getColumns().addAll(colNombre, colInici, colFin);
//        tablaCarrera.setItems(findAll());

    }

    private ObservableList<Carrera> findAll(){
        return FXCollections.observableArrayList(carreraService.findAll());
    }

}
