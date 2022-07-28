package com.challenge.alkemy.services.implement;

import com.challenge.alkemy.models.Admin;
import com.challenge.alkemy.repositories.AdminRepository;
import com.challenge.alkemy.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin getAdmin(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
