package com.instituto27.controller.inscripciones;

import com.instituto27.service.usuario.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by braian albo on 28/6/2018.
 */
@Controller
public class InscripcionController {

    @FXML
    private ComboBox selectCarreras;

    @FXML
    private TextField txtNOMBREYAPELLIDO;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextField txtEDAD;

    @FXML
    private TextField txtDOMICILIO;

    @FXML
    private TextField txtLOCALIDAD;

    @FXML
    private TextField txtPRONVICIA;

    @FXML
    private TextField txtTEL;

    @FXML
    private Button buttonGUARDAR;

    @FXML
    private Button buttonCANCELAR;

    @FXML
    private Button buttonBUSCAR;


    @Autowired
    private UsuarioService usuarioService;

    public void buscar(ActionEvent actionEvent) {
        String dni = txtDNI.getText();

        if(dni == ""){


        }

        else{

            usuarioService.getByDNI(dni);

        }



    }


    public void cancelar(ActionEvent actionEvent) {


    }

    public void guardar(ActionEvent actionEvent) {



    }








}
