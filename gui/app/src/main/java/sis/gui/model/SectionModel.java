package sis.gui.model;

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
        // numberProperty.bind(this.numberProperty);
        this.numberProperty.bindBidirectional(numberProperty);
    }

    public void setType(String type) {
        this.typeProperty.set(type);
    }

    public void bindType(StringProperty typeProperty) {
        this.typeProperty.bindBidirectional(typeProperty);
    }

    public void setCredits(String credits) {
        this.creditsProperty.set(credits);
    }

    public void bindCredits(StringProperty creditsProperty) {
        this.creditsProperty.bindBidirectional(creditsProperty);
    }

    public void setInstructor(String instructor) {
        this.instructorProperty.set(instructor);
    }

    public void bindInstructor(StringProperty instructorProperty) {
        this.instructorProperty.bindBidirectional(instructorProperty);
    }

    public void setTimes(String times) {
        this.timesProperty.set(times);
    }

    public void bindTimes(StringProperty timesProperty) {
        this.timesProperty.bindBidirectional(timesProperty);
    }

    public void setLocation(String location) {
        this.locationProperty.set(location);
    }

    public void bindLocation(StringProperty locationProperty) {
        this.locationProperty.bindBidirectional(locationProperty);
    }

    public void setWaitListInfo(String waitListInfo) {
        this.waitListInfoProperty.set(waitListInfo);
    }

    public void bindWaitListInfo(StringProperty waitListInfoProperty) {
        this.waitListInfoProperty.bindBidirectional(waitListInfoProperty);
    }

    public void setEnrollmentInfo(String enrollmentInfo) {
        this.enrollmentInfoProperty.set(enrollmentInfo);
    }

    public void bindEnrollmentInfo(StringProperty enrollmentInfoProperty) {
        this.enrollmentInfoProperty.bindBidirectional(enrollmentInfoProperty);
    }

    public void setStatus(String status) {
        this.statusProperty.set(status);
    }

    public void bindStatus(StringProperty statusProperty) {
        this.statusProperty.bindBidirectional(statusProperty);
    }
}
