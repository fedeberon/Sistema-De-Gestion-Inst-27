package controller.carreras;

import controller.HomeController;
import domain.carrera.Carrera;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.carreras.CarreraService;

import java.io.IOException;

/**
 * Created by ISFDyT Nº 27 on 30/05/2018.
 */
public class CarreraController {


    private CarreraService carreraService;

    @FXML
    public TableView tablaCarrera;

    public TableColumn colNombre = new TableColumn("Nombre");
    public TableColumn colInici = new TableColumn("Inicio");
    public TableColumn colFin = new TableColumn("Fin");

    @FXML
    public TextField txtAtras;


    public void guardarCarrera(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu/Home.fxml"));
        HomeController controller = loader.getController();
        controller.pnl_scroll.getChildren().clear();
        Node [] nodes = new  Node[2];
        Integer v = 1;
        nodes[v] = (Node) FXMLLoader.load(getClass().getResource("/fxml/carreras/list.fxml"));
        controller.pnl_scroll.getChildren().add(nodes[v]);
        controller.pnl_scroll.setVisible(true);


        tablaCarrera.getColumns().addAll(colNombre, colInici, colFin);
        tablaCarrera.setItems(findAll());
    }



    private ObservableList<Carrera> findAll(){
        return FXCollections.observableArrayList(carreraService.findAll());
    }

}
