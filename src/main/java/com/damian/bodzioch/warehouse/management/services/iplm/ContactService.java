package com.damian.bodzioch.warehouse.management.services.iplm;

import org.springframework.stereotype.Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class ContactService {
    public void sendMessage(String firstName, String lastName, String topic, String content) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "poczta.interia.pl");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "poczta.interia.pl");
        prop.put("mail.debug", "true");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("grzegorz.bacur@interia.pl", "Javaspring8");
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("grzegorz.bacur@interia.pl"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("grzegorz.bacur@interia.pl"));
            message.setSubject(topic);
            message.setText(content);

            Transport.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }


}