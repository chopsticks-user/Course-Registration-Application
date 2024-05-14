package sis.gui.runtime;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIService {
    public static void start(Stage stage) throws Exception {
        stage.setTitle("Course Registration");
        stage.setScene(new Scene(FXMLLoader.load(
                GUIService.class.getResource("../view/login/login-region.fxml")),
                1280, 720));
        stage.show();
    }
}
