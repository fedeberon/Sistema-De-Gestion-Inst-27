package com.instituto27.controller.notas;

import com.instituto27.main.Main;
import com.instituto27.service.nota.NotaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by ISFDyT Nº 27 on 08/11/2018.
 */
public class NotaListaController {

    @FXML
    public Button crearNota;

    @Autowired
    public NotaService notaService;
    @Autowired
    public NotaController notaController;

    /* IR A LA INTERFAZ DE CARGAR NOTA */
    public void crearNota(ActionEvent actionEvent) throws IOException {
        Node[] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = FXMLLoader.load(getClass().getResource("/fxml/notas/Notas.fxml"));
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        pnl_scroll.getChildren().add(nodes[v]);
    }

}
