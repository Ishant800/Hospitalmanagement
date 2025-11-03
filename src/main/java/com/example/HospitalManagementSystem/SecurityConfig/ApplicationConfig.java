package com.example.HospitalManagementSystem.SecurityConfig;

import com.example.HospitalManagementSystem.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepo userRepo;

//    @Bean
//    public UserDetailsService userDetailsService
}
