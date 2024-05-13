package sis.gui.runtime;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GUIService.start(stage);
    }
}
