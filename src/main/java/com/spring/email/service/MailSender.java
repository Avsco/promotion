package com.spring.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
    private JavaMailSender javaMailSender;

    @Autowired
    public MailSender(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMessage(){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("benacho82@gmail.com");
        mail.setFrom("benacho82@gmail.com");
        mail.setSubject("Test");
        mail.setText("test");

        javaMailSender.send(mail);
    }
}
