package sis.gui.view;

import javafx.scene.Scene;
import sis.gui.model.LogInInfoModel;
import sis.gui.util.ViewBuilder;

public class LogInViewBuilder implements ViewBuilder<Scene> {
    LogInRegionBuilder logInRegionBuilder;
    LogInBackgroundBuilder logInBackgroundBuilder;

    public LogInViewBuilder(LogInInfoModel logInInfoModel) {
        logInRegionBuilder = new LogInRegionBuilder(logInInfoModel);
        logInBackgroundBuilder = new LogInBackgroundBuilder();
    }

    @Override
    public Scene build() throws Exception {
        return new Scene(logInRegionBuilder.build(), 1280, 720);
    }
}
