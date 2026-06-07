package com.apisentinel.controller;

import com.apisentinel.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailTestController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/test-email")
    public String sendTestEmail() {

        emailService.sendApiDownAlert(
                "Test API",
                "https://test-api.com"
        );

        return "Email Sent Successfully";
    }
}