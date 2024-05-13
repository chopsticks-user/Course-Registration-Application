package sis.gui.runtime;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sis.gui.model.LogInInfoModel;
import sis.gui.view.LogInRegionBuilder;
import sis.gui.view.LogInSceneBuilder;

public class SIS extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Course Registration");
        stage.setScene(new LogInSceneBuilder(new LogInInfoModel()).build());
        stage.show();
    }
}
