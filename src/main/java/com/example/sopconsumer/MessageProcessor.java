package com.example.sopconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessageProcessor {

    private MailSenderService mailSenderService;

    @Autowired
    public void setMailSenderService(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }


    public void processMessage(String customerEmail, String orderStatus) {
        mailSenderService.sendSimpleMail("Dear client, your order status has changed", "New orders status: " + orderStatus, customerEmail);
        System.out.println("Mail sent");
    }

}