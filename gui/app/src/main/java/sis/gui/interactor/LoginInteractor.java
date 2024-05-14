package sis.gui.interactor;

import javafx.beans.property.StringProperty;
import sis.gui.dao.LoginDAO;
import sis.gui.model.LoginModel;

public class LoginInteractor {
    private LoginModel loginInfoModel;
    private LoginDAO loginDAO;

    public LoginInteractor(StringProperty usernameProperty,
            StringProperty passwordProperty) {
        loginInfoModel = new LoginModel();
        loginDAO = new LoginDAO();

        loginInfoModel.bindUsername(usernameProperty);
        loginInfoModel.bindPassword(passwordProperty);
    }

    public void verify() throws Exception {
        loginDAO.verify(loginInfoModel.getUsername(),
                loginInfoModel.getPassword());
    }
}
