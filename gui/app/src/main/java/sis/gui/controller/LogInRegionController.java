package sis.gui.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import sis.gui.model.SectionModel;

public class LogInRegionController {
    SectionModel sectionModel = new SectionModel();
    int i = 0;

    @FXML
    Text test;

    @FXML
    public void handleSignInButton() {
        sectionModel.bindNumber(test.textProperty());
        sectionModel.setNumber(String.valueOf(++i));
    }

    @FXML
    public void handleSignUpButton() {
        sectionModel.setNumber(String.valueOf(--i));
    }
}
