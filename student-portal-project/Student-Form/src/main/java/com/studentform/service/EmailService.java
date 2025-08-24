package com.studentform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String toEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Email Verification");
        message.setText("Hello " + name + ",\n\nThank you for registering. Please check your email to verify your account.\n\nRegards,\nStudent Form Team");
        message.setFrom("your_email@gmail.com"); // Replace with your sender email

        mailSender.send(message);
    }
}
