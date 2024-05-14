package sis.gui.dao;

public class LoginDAO {
    public void verify(String username, String password)
            throws IllegalArgumentException {
        if (username.isBlank() || password.isBlank()) {
            throw new IllegalArgumentException(
                    "Username and password must not be empty");
        }
    }
}
