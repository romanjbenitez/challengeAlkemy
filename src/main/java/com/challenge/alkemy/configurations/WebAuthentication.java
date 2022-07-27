package com.challenge.alkemy.configurations;

import com.challenge.alkemy.models.Admin;
import com.challenge.alkemy.repositories.AdminRepository;

import com.challenge.alkemy.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    AdminService adminService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(email -> {
            Admin admin = adminService.getAdmin(email);
            if (admin != null) {
                return new User(admin.getEmail(), admin.getPassword(),
                        AuthorityUtils.createAuthorityList("ADMIN"));
            } else {
                throw new UsernameNotFoundException("Unknown user: " + email);
            }
        });
    }
}
