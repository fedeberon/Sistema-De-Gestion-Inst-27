package com.instituto27.controller.reporte;

import com.instituto27.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class ReporteController {



    public void btnProfesores(ActionEvent actionEvent) throws IOException {
        Stage s = DrapoDashboard.getPrimaryStage();

        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");


        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = (Node) FXMLLoader.load(getClass().getResource("/fxml/reporte/ReporteProfesor.fxml"));
        pnl_scroll.getChildren().add(nodes[1]);

    }

    public void btnAlumnos(ActionEvent actionEvent) throws IOException {
        Stage s = Main.getPrimaryStage();

        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");

        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = (Node) FXMLLoader.load(getClass().getResource("/fxml/reporte/ReporteAlumno.fxml"));
        pnl_scroll.getChildren().add(nodes[1]);
    }

}
