package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.LoginDto;
import com.example.HospitalManagementSystem.dto.LoginResponseDto;
import com.example.HospitalManagementSystem.dto.UserDto;
import com.example.HospitalManagementSystem.entity.User;
import com.example.HospitalManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        return "Hello, " + authentication.getName() +
                " with roles " + authentication.getAuthorities();
    }

    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody UserDto dto){
        return ResponseEntity.ok(service.createUser(dto));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getalluser(){
        return ResponseEntity.ok(service.getalluser());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto dto){
       return ResponseEntity.ok(service.login(dto));
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getuseById(@PathVariable Long id){
        return ResponseEntity.ok(service.getUserById(id));
    }
}
