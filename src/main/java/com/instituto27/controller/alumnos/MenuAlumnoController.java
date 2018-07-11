package com.instituto27.controller.alumnos;

import com.instituto27.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by ISFDyT Nº 27 on 06/07/2018.
 */
@Component
public class MenuAlumnoController {


    public void buscarAlumnos(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/alumno/show.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node[] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

}
