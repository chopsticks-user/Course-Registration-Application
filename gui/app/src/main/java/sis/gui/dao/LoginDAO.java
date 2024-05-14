package sis.gui.dao;

import sis.gui.domain.Login;

public class LoginDAO {
    public void verify(Login login)
            throws IllegalArgumentException {
        if (login.username().isBlank() || login.password().isBlank()) {
            throw new IllegalArgumentException(
                    "Username and password must not be empty");
        }
    }
}
