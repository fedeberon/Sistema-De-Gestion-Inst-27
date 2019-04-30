package com.instituto27.controller.profesores;

import com.instituto27.domain.Profesor;
import com.instituto27.service.Verificador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.instituto27.service.profesor.ProfesorService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfesorController{

    private boolean modificando = false;
    private Integer idDelModificado;

    @Autowired
    private ProfesorService profesorService;

    @FXML
    public TabPane tabPane;

    @FXML
    public Tab loadTab;

    @FXML
    public Tab listTab;

    @FXML
    public Tab assignTab;

    @FXML
    public Button botonGuardar;

    @FXML
    public Button botonLimpiar;

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

    @FXML
    public TableView<Profesor> listProfesores;

    @FXML
    public TableColumn colNom;

    @FXML
    public TableColumn colApe;

    @FXML
    public TableColumn colDir;

    @FXML
    public TableColumn colNum;

    @FXML
    public TableColumn colCel;

    @FXML
    public TableColumn colFij;

    @FXML
    public TableColumn colCui;

    @FXML
    public TableColumn colFec;

    @FXML
    public Button botonAgregar;

    @FXML
    public Button botonModificar;

    @FXML
    public Button botonEliminar;

    //Controles de asignacion de materias a profesores

    //===========================================================================================
    //Controles de la función de carga de profesores

    public void guardar(ActionEvent actionEvent) throws IOException{
        /*Antes de intentar guardar los datos en la base, elimina cualquier probabilidad de cargar datos erroneos*/

        Verificador verificador = new Verificador();

        boolean[] validaciones = new boolean[7];
        validaciones[0] = verificador.chequearTexto(campoNombre.getText(), false) && campoNombre.getText().length() < 46;
        validaciones[1] = verificador.chequearTexto(campoApellido.getText(), false) && campoApellido.getText().length() < 46;
        validaciones[2] = verificador.chequearEspacios(campoDireccion.getText(), true) && campoDireccion.getText().length() <46;
        validaciones[3] = verificador.chequearNumero(campoNumero.getText(), true) && campoNumero.getText().length() < 5;
        validaciones[4] = verificador.chequearNumero(campoCelular.getText(), true) && campoCelular.getText().length() < 46;
        validaciones[5] = verificador.chequearNumero(campoFijo.getText(), true) && campoFijo.getText().length() < 46;
        validaciones[6] = verificador.chequearCuil(new String[]{campoCuilA.getText(), campoCuilB.getText(), campoCuilC.getText()});

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
            Profesor profesor = new Profesor();
            profesor.setNombre(campoNombre.getText());
            profesor.setApellido(campoApellido.getText());
            profesor.setDireccion(campoDireccion.getText());
            profesor.setNumero(campoNumero.getText());
            profesor.setCelular(campoCelular.getText());
            profesor.setFijo(campoFijo.getText());
            profesor.setCuil(campoCuilA.getText()+campoCuilB.getText()+campoCuilC.getText());
            profesor.setNacimiento(campoFecha.getValue());

            if(modificando){
                listTab.setDisable(false);
                assignTab.setDisable(false);
                tabPane.getSelectionModel().select(1);
//                profesor.setId(idDelModificado);
                profesorService.update(profesor);
                modificando = false;
            }else{
                profesorService.save(profesor);
            }

            this.limpiar();
            this.initialize();
        }
    }

    public void limpiar(){
        campoNombre.clear();
        campoApellido.clear();
        campoDireccion.clear();
        campoNumero.clear();
        campoCelular.clear();
        campoFijo.clear();
        campoCuilA.clear();
        campoCuilB.clear();
        campoCuilC.clear();
        campoFecha.getEditor().clear();
    }

    //===========================================================================================
    //Controles encontrados en la lista de profesores

    public void initialize(){
        colNom.setCellValueFactory(new PropertyValueFactory<Profesor, String>("nombre"));
        colApe.setCellValueFactory(new PropertyValueFactory<Profesor, String>("apellido"));
        colDir.setCellValueFactory(new PropertyValueFactory<Profesor, String>("direccion"));
        colNum.setCellValueFactory(new PropertyValueFactory<Profesor, String>("numero"));
        colCel.setCellValueFactory(new PropertyValueFactory<Profesor, String>("celular"));
        colFij.setCellValueFactory(new PropertyValueFactory<Profesor, String>("fijo"));
        colCui.setCellValueFactory(new PropertyValueFactory<Profesor, String>("cuil"));
        colFec.setCellValueFactory(new PropertyValueFactory<Profesor, String>("nacimiento"));
        listProfesores.setItems(getEnseignant());
        botonEliminar.disableProperty().bind(Bindings.isEmpty(listProfesores.getSelectionModel().getSelectedItems()));
        botonModificar.disableProperty().bind(Bindings.isEmpty(listProfesores.getSelectionModel().getSelectedItems()));
    }

    public ObservableList<Profesor> getEnseignant() {
        ObservableList<Profesor> enseignantList = FXCollections.observableArrayList();
        List<Profesor> eList = profesorService.findAll();
        for (Profesor ent : eList) {
            enseignantList.add(ent);
        }
        return enseignantList;
    }

    public void agregar(){
        tabPane.getSelectionModel().select(0);
    }

    public void modificar() {
        Profesor profesor = listProfesores.getSelectionModel().getSelectedItem();
        campoNombre.setText(profesor.getNombre());
        campoApellido.setText(profesor.getApellido());
        campoDireccion.setText(profesor.getDireccion());
        campoNumero.setText(profesor.getNumero());
        campoCelular.setText(profesor.getCelular());
        campoFijo.setText(profesor.getFijo());
        campoCuilA.setText(profesor.getCuil().isEmpty()?"":(profesor.getCuil().substring(0, 2)));
        campoCuilB.setText(profesor.getCuil().isEmpty()?"":(profesor.getCuil().substring(2, 10)));
        campoCuilC.setText(profesor.getCuil().isEmpty()?"":(profesor.getCuil().substring(10, 11)));
        campoFecha.setValue(profesor.getNacimiento());
        tabPane.getSelectionModel().select(0);
        listTab.setDisable(true);
        assignTab.setDisable(true);
        modificando = true;
//        idDelModificado = profesor.getId();
    }

    //Elimina todos los registros de la tabla y la base de datos
    public void eliminar() {
        Profesor profesor = listProfesores.getSelectionModel().getSelectedItem();
        listProfesores.getItems().remove(profesor);
        profesorService.delete(profesor);
    }
}

