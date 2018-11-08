package com.instituto27.controller.inscripciones;

import com.instituto27.domain.Alumno;
import com.instituto27.domain.Inscripcion;
import com.instituto27.domain.carrera.Carrera;
import com.instituto27.service.alumno.AlumnoService;
import com.instituto27.service.carreras.CarreraService;
import com.instituto27.service.inscripcion.InscripcionService;
import com.instituto27.service.usuario.UsuarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by braian albo on 28/6/2018.
 */
@Controller
public class InscripcionController implements Initializable{

    @FXML
    private ComboBox<Carrera> cmbCarrera;

    @FXML
    private TextField txtDni;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AlumnoService alumnoService;


    @Autowired
    private CarreraService carreraService;

    @Autowired
    private InscripcionService inscripcionService;

    public void guardar(){
        String dni = txtDni.getText();
        Alumno alumno = alumnoService.getByDni(dni);

        if(alumno == null){
            // mandas  un mensaje que de que el aumno no existe, Que lo cargue
        }

        else {

            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setAlumno(alumno);
            inscripcion.setCarrera(cmbCarrera.getValue());
            inscripcionService.save(inscripcion);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbCarrera.setItems(getCarreras());
    }


    public ObservableList<Carrera> getCarreras(){
        ObservableList<Carrera> carreras = FXCollections.observableArrayList();
        List<Carrera> list = carreraService.findAll();
        for(Carrera c  : list){
            carreras.add(c);
        }

        return carreras;
    }


}

