package com.example.HospitalManagementSystem.Jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Jwtservice {
    @Value("${jwt.secrete}")
    private final String SECRET_KEY;


    public Jwtservice(String secretKey) {
        SECRET_KEY = secretKey;
    }


//    public String generateToken(Map<String,Object> extraClaims,UserDetails userDetails){
//
//    }
}
