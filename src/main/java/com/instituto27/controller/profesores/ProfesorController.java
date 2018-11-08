package com.instituto27.controller.profesores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.instituto27.service.profesor.ProfesorService;

import java.time.LocalDate;
import java.util.ArrayList;


public class ProfesorController{
    @FXML
    public Button botonGuardar;

    @FXML
    public TextField campoNombre;

    @FXML
    public TextField campoApellido;

    @FXML
    public TextField campoDireccion;

    @FXML
    public TextField campoNumero;

    @FXML
    public TextField campoCelular;

    @FXML
    public TextField campoFijo;

    @FXML
    public TextField campoCuilA;

    @FXML
    public TextField campoCuilB;

    @FXML
    public TextField campoCuilC;

    @FXML
    public DatePicker campoFecha;

    @FXML
    public Label mensajeError;

    @FXML
    public ComboBox comboNombreProfesores;

    @FXML
    public ScrollPane listaDeMateriasAElegir;


    private ProfesorService profesorService = new ProfesorService();
    private LocalDate diaNacimiento;


    public void guardar(ActionEvent actionEvent) {
        /*Antes de intentar guardar los datos en la base, elimina cualquier probabilidad de cargar datos erroneos*/

        boolean[] validaciones = new boolean[7];
        validaciones[0] = profesorService.verificarTextoObligatorio(campoNombre.getText()) && campoNombre.getText().length() < 46;
        validaciones[1] = profesorService.verificarTextoObligatorio(campoApellido.getText()) && campoApellido.getText().length() < 46;
        validaciones[2] = campoDireccion.getText().length() <46;
        validaciones[3] = profesorService.verificarNumero(campoNumero.getText()) && campoNumero.getText().length() < 5;
        validaciones[4] = profesorService.verificarNumero(campoCelular.getText()) && campoCelular.getText().length() < 46;
        validaciones[5] = profesorService.verificarNumero(campoFijo.getText()) && campoFijo.getText().length() < 46;
        validaciones[6] = profesorService.verificarCuil(campoCuilA.getText(), campoCuilB.getText(), campoCuilC.getText());
        /*La siguiente seccion concatena todos los nombres de error que puedan ir surgientdo
          No hay ningun verificador para la fecha porque el selector de fecha no permite que
          se introduzca ningun dato inapropiado*/

        ArrayList<String> msjError = new ArrayList<>();
        StringBuilder msjErrorFinal = new StringBuilder();

        for(boolean x: validaciones){
            if(!x && msjErrorFinal.length() == 0){
                msjErrorFinal.append("Error en: ");
            }
        }

        //Verifica una por una las validaciones realizadas y registra cualquier error que suceda
        for (int i = 0; i<validaciones.length; i++){
            switch (i){
                case 0:
                    if(!validaciones[0]){msjError.add("nombre");}break;
                case 1:
                    if(!validaciones[1]){msjError.add("apellido");}break;
                case 2:
                    if(!validaciones[2]){msjError.add("direccion");}break;
                case 3:
                    if(!validaciones[3]){msjError.add("numero");}break;
                case 4:
                    if(!validaciones[4]){msjError.add("celular");}break;
                case 5:
                    if(!validaciones[5]){msjError.add("tel. fijo");}break;
                default:
                    if(!validaciones[6]){msjError.add("cuil");}break;
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
        }
    }
}
