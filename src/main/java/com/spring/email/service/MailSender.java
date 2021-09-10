package com.spring.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMessage(){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("benacho82@gmail.com");

        mail.setSubject("Test");
        mail.setText("test");

        this.javaMailSender.send(mail);
    }
}
