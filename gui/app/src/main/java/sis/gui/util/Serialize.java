package sis.gui.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Serialize {
    private static final Gson gson = new GsonBuilder().serializeNulls().create();

    public static <T> String stringify(T object) {
        return gson.toJson(object);
    }

    public static <T> T parse(String json, Class<T> classType) {
        return gson.fromJson(json, classType);
    }
}
