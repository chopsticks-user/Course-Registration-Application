package sis.gui.dao;

import sis.gui.domain.Login;
import sis.gui.util.Serialize;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class LoginDAO {
    public void verify(Login login)
            throws Exception {
        URL url = new URL("http://192.168.0.19:8080/sessions/login");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        var dos = new DataOutputStream(connection.getOutputStream());
        dos.writeBytes(Serialize.stringify(login));

        // Send the request
        int responseCode = connection.getResponseCode();
        System.out.println(String.format("Response Code: %s, Message: %s",
                responseCode, connection.getResponseMessage()));

        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Print the response
        System.out.println("Response Body: " + response.toString());

        connection.disconnect();
    }
}
