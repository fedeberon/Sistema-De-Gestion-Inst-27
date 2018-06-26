package controller.login;

import config.AppConfig;
import controller.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.usuario.UsuarioService;

import java.io.IOException;


@Controller
public class LoginController {

    @FXML
    public TextField username;

    @FXML
    public PasswordField password;

    @FXML
    public Label mensajeValidacion;

    @Autowired
    private UsuarioService usuarioService;

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
        } else mensajeValidacion.setText("x El usuario o password son incorrectos");
    }
}
