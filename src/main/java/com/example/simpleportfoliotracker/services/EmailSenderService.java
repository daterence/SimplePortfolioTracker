package com.example.simpleportfoliotracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(String toEmail, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("simpleportfoliotracker@gmail.com");
        message.setTo(toEmail);
        message.setText(username + " account has been created successfully");
        message.setSubject("Registration to SimplePortfolio Tracker");

        javaMailSender.send(message);

        System.out.println("Mail sent successfully...");
        return "success";
    }
}
