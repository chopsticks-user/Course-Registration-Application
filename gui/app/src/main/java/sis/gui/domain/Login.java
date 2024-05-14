package sis.gui.domain;

import com.google.gson.Gson;

public record Login(String username, String password) {
    public String stringify() {
        return new Gson().toJson(this);
    }
}
