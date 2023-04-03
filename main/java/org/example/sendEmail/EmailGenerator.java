package org.example.sendEmail;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EmailGenerator {
    private String password;
    private String email;
    public EmailGenerator(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://temp-gmail.p.rapidapi.com/get?domain=gmail.com&username=random&server=server-1&type=alias"))
                .header("X-RapidAPI-Key", "4ff56ab9d4msh1e4d559e8f11bdcp11e3f0jsnd55ee22ceff0")
                .header("X-RapidAPI-Host", "temp-gmail.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }catch (Exception e){
            System.out.println("Exception: Failed to send the email");
        }

    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
