package com.instituto27.controller.login;

import com.instituto27.domain.Persona;
import com.instituto27.domain.Usuario;
import com.instituto27.main.Main;
import com.instituto27.service.usuario.UsuarioService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.logging.Handler;

/**
 * Created by ISFDyT Nº 27 on 29/05/2018.
 */
@Component
public class LoginController {

    @FXML
    public TextField username;

    @FXML
    public PasswordField password;

    @FXML
    public Label mensajeValidacion;

    @FXML
    public Button btnLogin;

    @FXML
    public Button btnIngresar;

    @Autowired
    private UsuarioService usuarioService;


    public void init(){
        btnIngresar.fire();
    }




    public void login(ActionEvent actionEvent) throws IOException {
        boolean esUnUsuarioValido = usuarioService.validarUsuarioYPassword(username.getText(), password.getText());
        if (esUnUsuarioValido) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            System.out.print("El usuario es : " + username.getText() + " y el password es : " + password.getText());
            fxmlLoader.setLocation(getClass().getResource("/fxml/menu/Home.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();

            Persona persona = usuarioService.get(username.getText());

            // evaluar usuario
            String quienSoy = persona.evaluar(usuario -> "Usuario", profesor -> "Profesor", alumno -> "Alumno",administrativo -> "Administrativo");

            stage.setTitle(persona.getNombre() + " "  + persona.getApellido() + " - " + quienSoy);

            stage.setScene(scene);
            stage.show();
            Main.primaryStage = stage;
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        } else mensajeValidacion.setText("x El usuario o password son incorrectos");


    }

}
