package com.challenge.alkemy.services;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmail(String to);
}
