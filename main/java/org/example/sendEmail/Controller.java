package org.example.sendEmail;

import java.util.Map;

public class Controller {
    private SendEmail sendEmail;
    public Controller(){
        Map<String, String> env = System.getenv();
        sendEmail = new SendEmail("lashkiba.st.lorenzo@maxplanck.edu.it","lorenzoboiko@gmail.com",env.get("password"));
    }

    public void sendDefaultEmail(){
        sendEmail.send();
    }
    public void sendToAll(){

    }
    public void sendCustomEmail(String email){
        sendEmail.send(email);
    }
}
