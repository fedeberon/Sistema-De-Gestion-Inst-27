package com.instituto27.controller.reporte;

import com.instituto27.main.Main;
import com.instituto27.service.alumno.AlumnoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class ReporteController {

    @Autowired
    private AlumnoService alumnoService;

    public void btnProfesores(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/reporte/ReporteProfesor.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);

        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);

    }

    public void btnAlumnos(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/reporte/ReporteAlumno.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);

        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }


    public void btnAtras(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/reporte/Reportes.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);

        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);

    }
}
