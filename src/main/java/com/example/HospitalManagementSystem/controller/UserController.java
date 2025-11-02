package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.UserDto;
import com.example.HospitalManagementSystem.entity.User;
import com.example.HospitalManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService service;




    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody UserDto dto){
        return ResponseEntity.ok(service.createUser(dto));
    }

    @GetMapping
    public ResponseEntity<List<User>> getalluser(){
        return ResponseEntity.ok(service.getalluser());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto dto){
       return ResponseEntity.ok(service.login(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getuseById(@PathVariable Long id){
        return ResponseEntity.ok(service.getUserById(id));
    }
}
