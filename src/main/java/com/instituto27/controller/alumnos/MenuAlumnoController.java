package com.instituto27.controller.alumnos;

import com.instituto27.domain.Alumno;
import com.instituto27.main.Main;
import com.instituto27.service.Verificador;
import com.instituto27.service.alumno.AlumnoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ISFDyT Nº 27 on 06/07/2018.
 */
@Component
public class MenuAlumnoController {

    @FXML
    public TextField aluNombre;

    @FXML
    public TextField aluApellido;

    @FXML
    public TextField aluDni;

    @FXML
    public DatePicker aluFecNac;

    @FXML
    public TextField aluCelular;

    @FXML
    public TextField aluDireccion;

    @FXML
    public TextField aluEmail;

    @FXML
    public Label mensajeError;

    @Autowired
    private AlumnoService alumnoService;

//    @Autowired
//    private Verificador verificador;

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

    public void cargarAlumnos(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/alumno/create.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void createAtras(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/alumno/home.fxml"));
        fxmlLoader.setControllerFactory(Main.springContext::getBean);
        Stage s = Main.getPrimaryStage();
        VBox pnl_scroll = (VBox) s.getScene().lookup("#pnl_scroll");
        pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        nodes[1] = fxmlLoader.load();
        pnl_scroll.getChildren().add(nodes[1]);
    }

    public void save(ActionEvent actionEvent) throws IOException {
        Alumno alumno = new Alumno();
        alumno.setNombre(aluNombre.getText());
        alumno.setApellido(aluApellido.getText());
        alumno.setDNI(aluDni.getText());
        alumno.setCelular(aluCelular.getText());
        alumno.setDireccion(aluDireccion.getText());
        alumno.setEmail(aluEmail.getText());
        alumno.setFechaNacimiento(aluFecNac.getValue());

        /*Antes de intentar guardar los datos en la base, elimina cualquier probabilidad de cargar datos erroneos*/

        Verificador verificador = new Verificador();


        boolean[] validaciones = new boolean[5];
        validaciones[0] = verificador.chequearTexto(aluNombre.getText(), false) && aluNombre.getText().length() < 46;
        validaciones[1] = verificador.chequearTexto(aluApellido.getText(), false) && aluApellido.getText().length() < 46;
        validaciones[2] = aluDireccion.getText().length() <46;
        validaciones[3] = verificador.chequearNumero(aluDni.getText(), true) && aluDni.getText().length() < 9;
        validaciones[4] = verificador.chequearNumero(aluCelular.getText(), true) && aluCelular.getText().length() < 46;
        /*La siguiente seccion concatena todos los nombres de error que puedan ir surgientdo
          No hay ningun verificador para la fecha porque el selector de fecha no permite que
          se introduzca ningun dato inapropiado*/

        ArrayList<String> msjError = new ArrayList<>();
        StringBuilder msjErrorFinal = new StringBuilder();

        for(boolean x: validaciones){
            if(!x && msjErrorFinal.length() == 0){
                msjErrorFinal.append("Error en el campo: ");
            }
        }

        //Verifica una por una las validaciones realizadas y registra cualquier error que suceda
        for (int i = 0; i<validaciones.length; i++){
            switch (i){
                case 0:
                    if(!validaciones[0]){msjError.add("Nombre");}break;
                case 1:
                    if(!validaciones[1]){msjError.add("Apellido");}break;
                case 2:
                    if(!validaciones[2]){msjError.add("Direccion");}break;
                case 3:
                    if(!validaciones[3]){msjError.add("Dni");}break;
                case 4:
                    if(!validaciones[4]){msjError.add("Celular");}break;
                default:
                    if(!validaciones[6]){msjError.add("");}break;
            }
        }

        //Une cada uno de los mensajes de error que puedan surgir.
        for (int i = 0; i<msjError.size(); i++){
            if(msjError.size() != 0){
                msjErrorFinal.append(msjError.get(i));
                if(i<(msjError.size()-2)){
                    msjErrorFinal.append(", ");
                }else if(i == (msjError.size()-2)){
                    msjErrorFinal.append(" y ");
                }
            }
        }

        if(msjErrorFinal.length() > 0){
            mensajeError.setText(msjErrorFinal.toString());
        }else{
            mensajeError.setText("*: Campo obligatorio");
            alumnoService.save(alumno);
            vaciarCampos();
        }

    }

    public void vaciarCampos(){
        aluNombre.clear();
        aluApellido.clear();
        aluDni.clear();
        aluCelular.clear();
        aluDireccion.clear();
        aluEmail.clear();
        aluFecNac.getEditor().clear();
    }

}
