package sis.gui.view;

import javafx.scene.Scene;
import javafx.util.Builder;
import sis.gui.model.LogInInfoModel;
import sis.gui.util.ViewBuilder;

public class LogInSceneBuilder implements ViewBuilder<Scene> {
    LogInRegionBuilder logInRegionBuilder;

    public LogInSceneBuilder(LogInInfoModel logInInfoModel) {
        logInRegionBuilder = new LogInRegionBuilder(logInInfoModel);
    }

    @Override
    public Scene build() throws Exception {
        return new Scene(logInRegionBuilder.build(), 1280, 720);
    }
}
