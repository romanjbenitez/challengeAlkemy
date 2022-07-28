package com.challenge.alkemy.services.implement;

import com.challenge.alkemy.services.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("alkemydisney@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("Welcome to disney alkemy rest api");
        simpleMailMessage.setText("Welcome to disney alkemy rest api");
        this.mailSender.send(simpleMailMessage);
    }
}
