package org.example.sendEmail;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendEmail {
    private String defaultTo;
    private String tempTo;
    private String from;
    private String password;
    private String username;
    private Session session;
    public SendEmail(String to,String from,String password){
        this.defaultTo = to;
        this.from = from;
        this.username= from;
        this.password = password;
        this.session = this.startSession();
    }
    public Session startSession(){
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        return session;
    }

    public String readHtmlFile(String path){
        StringBuilder html = new StringBuilder();
        String result = "error";
        try {
            // Reading html file on local directory
            FileReader fr = new FileReader(path);
            // Initialization of the buffered Reader to get
            // the String append to the String Builder
            BufferedReader br = new BufferedReader(fr);
            String val;
            // Reading the String till we get the null
            // string and appending to the string
            while ((val = br.readLine()) != null) {
                html.append(val);
            }
            // AtLast converting into the string
            result = html.toString();
            // Closing the file after all the completion of
            // Extracting
            br.close();
        }
        // Catch block to handle exceptions
        catch (Exception ex) {
            /* Exception of not finding the location and
            string reading termination the function
            br.close(); */
            System.err.print(ex.getMessage());
        }
        return result;
    }
    public void send(String to) {

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            // Set Subject
            message.setSubject("Hi "+to.split("@")[0]);
              /* Constructing String Builder to
            append the string into the html */
            String result = readHtmlFile("src/main/java/org/example/sendEmail/index.html");
            message.setContent( result, "text/html; charset=utf-8");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            System.err.print("ERROR: couldn't send the email { "+e+" }");
        }
    }
    public void send(){
        send(defaultTo);
    }
}