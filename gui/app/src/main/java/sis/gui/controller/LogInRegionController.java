package sis.gui.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sis.gui.domain.Login;
import sis.gui.interactor.LoginInteractor;
import sis.gui.util.Serialize;

public class LogInRegionController {
    LoginInteractor loginInteractor;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    Label messageLabel;

    public void initialize() {
        Platform.runLater(() -> {
            loginInteractor = new LoginInteractor(
                    usernameField.textProperty(), passwordField.textProperty());
        });
    }

    @FXML
    public void handleSignInButton() {
        try {
            loginInteractor.verify();
            messageLabel.setText("Success! You are now logged in");
        } catch (Exception e) {
            messageLabel.setText(e.getMessage());
        }
    }

    @FXML
    public void handleSignUpButton() {
    }
}
