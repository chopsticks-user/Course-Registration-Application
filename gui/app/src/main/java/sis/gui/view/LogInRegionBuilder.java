package sis.gui.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import sis.gui.model.LogInInfoModel;
import sis.gui.util.ViewBuilder;

public class LogInRegionBuilder implements ViewBuilder<Region> {
    private final LogInInfoModel logInInfoModel;

    public LogInRegionBuilder(LogInInfoModel logInInfoModel) {
        this.logInInfoModel = logInInfoModel;
    }

    @Override
    public Region build() throws Exception {
        Region region = FXMLLoader.load(
                LogInRegionBuilder.class.getResource("login-region.fxml"));
        logInInfoModel.bindUsername(
                ((TextField) (region.lookup("#usernameField"))).textProperty());
        logInInfoModel.bindPassword(
                ((TextField) (region.lookup("#passwordField"))).textProperty());
        return region;
    }
}
