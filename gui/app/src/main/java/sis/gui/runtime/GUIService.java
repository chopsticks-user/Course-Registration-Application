package sis.gui.runtime;

import javafx.stage.Stage;
import sis.gui.model.LogInInfoModel;
import sis.gui.view.LogInViewBuilder;

public class GUIService {
    public static void start(Stage stage) throws Exception {
        stage.setTitle("Course Registration");
        stage.setScene(new LogInViewBuilder(new LogInInfoModel()).build());
        stage.show();
    }
}
