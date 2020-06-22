package pl.recruitingWorkflowApp.service;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

@Component
public class EmailService implements CommandLineRunner {

    public void run(String... args) throws Exception {

        final String username = "twójmail@gmail.com";
        final String password = "hasło";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");//TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        //jak napisać metodę, która będzie pobierać datę z listy procesów i wysyłać przypomnienie dzień przed?
        // dotarłam, żeby skorzystać z @Scheduled(fixedDelay = 3600000) - uruchamianie procesu co godzinę fixedDelay = 3600000.
        // Można użyć też cron = 0 0 0 * * * w celu uruchamiania procesu o 00:00 codziennie albo cron = "0 0-59 0-23 * * *",
        // żeby sprawdzało co minutę.

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("twójmail@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("maildocelowy@gmail.com")
            );
            message.setSubject("Notify from RecruitingWorkflowApp");
            message.setText("Zbliża się koniec rekrutacji");

            Transport.send(message);

            System.out.println("Test Email Sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}