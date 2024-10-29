package com.example.sopconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailSenderService {

    private final JavaMailSender javaMailSender;


    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Value("${spring.mail.username}")
    private String senderMail;


    public void sendSimpleMail(String subject, String body, String userMail) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userMail);
        message.setFrom(senderMail);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);

    }

}