package sis.gui.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sis.gui.model.LoginInfoModel;

public class LogInRegionController {
    LoginInfoModel loginInfoModel;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    public void initialize() {
        loginInfoModel = new LoginInfoModel();
        Platform.runLater(() -> {
            loginInfoModel.bindUsername(usernameField.textProperty());
            loginInfoModel.bindPassword(passwordField.textProperty());
        });
    }

    @FXML
    public void handleSignInButton() {
        System.out.println(loginInfoModel.getUsername());
        System.out.println(loginInfoModel.getPassword());
    }

    @FXML
    public void handleSignUpButton() {
    }
}
