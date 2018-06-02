package controller.login;

import controller.DrapoDashboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.usuario.UsuarioService;

import java.io.IOException;

/**
 * Created by ISFDyT Nº 27 on 29/05/2018.
 */
public class LoginController {

    @FXML
    public TextField username;

    @FXML
    public PasswordField password;

    @FXML
    public Label mensajeValidacion;


    private UsuarioService usuarioService = new UsuarioService();


    public void login(ActionEvent actionEvent) throws IOException {
        boolean esUnUsuarioValido = usuarioService.validarUsuarioYPassword(username.getText(), password.getText());

        if (esUnUsuarioValido) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            System.out.print("El usuario es : " + username.getText() + " y el password es : " + password.getText());
            fxmlLoader.setLocation(getClass().getResource("/fxml/menu/Home.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Usuario " + username.getText());
            stage.setScene(scene);
            stage.show();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        } else mensajeValidacion.setText("El usuario o pass son incorrectos");
    }
}
