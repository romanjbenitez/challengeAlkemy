package com.challenge.alkemy.services;


import com.challenge.alkemy.models.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    Admin getAdmin(String email);

    void saveAdmin(Admin admin);

}
