package com.challenge.alkemy.controllers;

import com.challenge.alkemy.models.Admin;
import com.challenge.alkemy.services.AdminService;
import com.challenge.alkemy.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<Object> createAdmin(@RequestParam String email, @RequestParam String password) {
        if (email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }
        if (!email.contains("@")) {
            return new ResponseEntity<>("Please insert a valid Email", HttpStatus.FORBIDDEN);
        }


        adminService.saveAdmin(new Admin(email, passwordEncoder.encode(password)));
        emailService.sendEmail(email);

        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }
}
