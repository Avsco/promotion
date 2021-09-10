package com.spring.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMessage(String message){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("atesta657a@gmail.com");

        mail.setSubject("Promotion");
        mail.setText(message);

        this.javaMailSender.send(mail);
    }
}
