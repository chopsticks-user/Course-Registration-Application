package sis.gui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginInfoModel {
    StringProperty usernameProperty = new SimpleStringProperty("");
    StringProperty passwordProperty = new SimpleStringProperty("");

    public LoginInfoModel() {
    }

    public void setUsername(String username) {
        usernameProperty.set(username);
    }

    public String getUsername() {
        return usernameProperty.get();
    }

    public void bindUsername(StringProperty usernameProperty) {
        this.usernameProperty.bindBidirectional(usernameProperty);
    }

    public String getPassword() {
        return passwordProperty.get();
    }

    public void setPassword(String password) {
        passwordProperty.set(password);
    }

    public void bindPassword(StringProperty passwordProperty) {
        this.passwordProperty.bindBidirectional(passwordProperty);
    }
}
