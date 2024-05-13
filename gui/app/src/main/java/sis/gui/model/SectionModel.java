package sis.gui.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SectionModel {
    protected StringProperty numberProperty = new SimpleStringProperty("");
    protected StringProperty typeProperty = new SimpleStringProperty("");
    protected StringProperty creditsProperty = new SimpleStringProperty("");
    protected StringProperty instructorProperty = new SimpleStringProperty("");
    protected StringProperty timesProperty = new SimpleStringProperty("");
    protected StringProperty locationProperty = new SimpleStringProperty("");

    protected StringProperty waitListInfoProperty = new SimpleStringProperty("");
    protected StringProperty enrollmentInfoProperty = new SimpleStringProperty("");
    protected StringProperty statusProperty = new SimpleStringProperty("");

    public SectionModel() {
    }

    public void setNumber(String number) {
        this.numberProperty.set(number);
    }

    public void bindNumber(StringProperty numberProperty) {
        this.numberProperty.bind(numberProperty);
    }

    public void setType(String type) {
        this.typeProperty.set(type);
    }

    public void bindType(StringProperty typeProperty) {
        this.typeProperty = typeProperty;
    }

    public void setCredits(String credits) {
        this.creditsProperty.set(credits);
    }

    public void bindCredits(StringProperty creditsProperty) {
        this.creditsProperty.bind(creditsProperty);
    }
}
