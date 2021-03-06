/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instituto27.controller;

import com.instituto27.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author oXCToo
 */
@SuppressWarnings("Duplicates")
public class HomeController implements Initializable {
    @FXML
    private Label label;

    @FXML
    public VBox pnl_scroll;

    @FXML
    public AnchorPane menu;


    @FXML
    private void handleButtonAction(MouseEvent event) throws IOException {
       refreshNodes();
       pnl_scroll.setVisible(true);
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
        nodes[1] = (Node)FXMLLoader.load(getClass().getResource("/fxml/alumno/home.fxml"));
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void btnProfesores(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/profesor/Profesor.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void btnCarreras(ActionEvent actionEvent) throws IOException {
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        Integer v = 1;
        nodes[v]=(Node) FXMLLoader.load(getClass().getResource("/fxml/carreras/home.fxml"));
        pnl_scroll.getChildren().add(nodes[v]);
        pnl_scroll.setVisible(true);
    }

    public void btnMaterias (ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/materias/Materias.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }


    public void btnReporte(ActionEvent actionEvent) throws IOException {
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[15];
        Integer v = 1;
        nodes[v] = (Node)FXMLLoader.load(getClass().getResource("/fxml/reporte/Reportes.fxml"));
        pnl_scroll.getChildren().add(nodes[v]);
    }


    public void btnInscripcion(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/inscripciones/inscripciones.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void btnEditProfile(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/usuario/EditarUsuario.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }



    public void btnNotas(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/notas/Notas.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

}
