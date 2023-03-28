package org.example.sendEmail;
import java.util.Properties;

import javax.mail.Session;

public class Email {
    public static void main(String[] args) {

        System.out.println("SimpleEmail Start");

        String smtpHostServer = "org.example.com";
        String emailID = "@example.com";

        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtpHostServer);

        Session session = Session.getInstance(props, null);

        SendEmail.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
    }

}
