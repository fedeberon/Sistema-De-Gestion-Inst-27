package com.instituto27.controller.notas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.stereotype.Controller;

/**
 * Created by ISFDyT Nº 27 on 28/06/2018.
 */

@Controller
public class NotasController {

    @FXML
    public Label labelHolaMundo;

    @FXML
    public TextField textNombre;

    @FXML
    public Button botonGuardar;

    @FXML
    public Button botonEditar;

    @FXML
    ChoiceBox<String> choiceBoxCarreras = new ChoiceBox<String>();

    public void guardarNota(ActionEvent actionEvent) {

    }

    public void editarNota(ActionEvent actionEvent) {

    }
}