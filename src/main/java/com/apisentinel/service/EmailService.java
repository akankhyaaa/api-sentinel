package com.apisentinel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendApiDownAlert(String apiName, String url) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("akankhyalenka2003@gmail.com");

        message.setSubject("🚨 API DOWN ALERT");

        message.setText(
                "API Name: " + apiName +
                "\nURL: " + url +
                "\nStatus: DOWN"
        );

        mailSender.send(message);
    }
}
