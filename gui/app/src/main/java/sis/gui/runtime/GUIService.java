package sis.gui.runtime;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIService {
    public static void start(Stage stage) throws Exception {
        stage.setTitle("Course Registration");

        var scene = new Scene(FXMLLoader.load(
                GUIService.class.getResource("../view/login/login-scene.fxml")),
                1280, 720);
        scene.getStylesheets().add(
                GUIService.class.getResource("../view/login/login.css")
                        .toExternalForm());

        stage.setScene(scene);
        stage.show();
    }
}
