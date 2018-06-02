/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private VBox pnl_scroll;

    @FXML
    private void handleButtonAction(MouseEvent event) throws IOException {
       refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            refreshNodes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void refreshNodes() throws IOException {
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[15];
        Integer v = 1;
        nodes[v] = (Node)FXMLLoader.load(getClass().getResource("/fxml/menu/Item.fxml"));
        pnl_scroll.getChildren().add(nodes[v]);
    }

    public void btnAlumnos(ActionEvent actionEvent) throws IOException {
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = (Node)FXMLLoader.load(getClass().getResource("/fxml/alumno/Alumnos.fxml"));
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void btnProfesores(ActionEvent actionEvent) throws IOException {
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = (Node)FXMLLoader.load(getClass().getResource("/fxml/menu/Item.fxml"));
        pnl_scroll.getChildren().add(nodes[v]);
    }

    public void btnCarreras(ActionEvent actionEvent) throws IOException {
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[15];
        Integer v = 1;
        nodes[v] = (Node)FXMLLoader.load(getClass().getResource("/fxml/menu/Carreras.fxml"));
        pnl_scroll.getChildren().add(nodes[v]);
    }


    public void btnReporte(ActionEvent actionEvent) throws IOException {
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[15];
        Integer v = 1;
        nodes[v] = (Node)FXMLLoader.load(getClass().getResource("/fxml/reporte/Reportes.fxml"));
        pnl_scroll.getChildren().add(nodes[v]);
    }



}
