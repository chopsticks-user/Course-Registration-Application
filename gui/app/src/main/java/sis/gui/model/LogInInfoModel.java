package sis.gui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LogInInfoModel {
    StringProperty usernameProperty = new SimpleStringProperty("");
    StringProperty passwordProperty = new SimpleStringProperty("");

    public LogInInfoModel() {
    }

    public void setUsername(String username) {
        this.usernameProperty.set(username);
    }

    public void bindUsername(StringProperty usernameProperty) {
        this.usernameProperty.bindBidirectional(usernameProperty);
    }

    public void setPassword(String password) {
        this.passwordProperty.set(password);
    }

    public void bindPassword(StringProperty passwordProperty) {
        this.passwordProperty.bindBidirectional(passwordProperty);
    }
}
