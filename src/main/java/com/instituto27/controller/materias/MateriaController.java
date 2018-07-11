package com.instituto27.controller.materias;

import com.instituto27.domain.Materia;
import com.instituto27.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by 12012018 on 07/06/2018.
 */
public class MateriaController {

    @FXML
    public Button btnCrearCarrera;

    @FXML
    public TextField materia;

    @FXML
    public TextField profesor;

    @FXML
    public Button btnGuardar;

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

    }
}

