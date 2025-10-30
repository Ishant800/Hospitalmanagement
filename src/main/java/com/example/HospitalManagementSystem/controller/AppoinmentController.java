package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.AppoinmentDto;
import com.example.HospitalManagementSystem.entity.Appoinment;
import com.example.HospitalManagementSystem.service.AppoinmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
public class AppoinmentController {
    private final AppoinmetService appoinmetService;

    @Autowired
    public  AppoinmentController(AppoinmetService appoinmetService){
        this.appoinmetService = appoinmetService;
    }

    @PostMapping
    public ResponseEntity<Appoinment> createAppoinment(@RequestBody AppoinmentDto dto){
        Appoinment appoinment = appoinmetService.createAppoinment(dto);
        System.out.println(appoinment);
        return ResponseEntity.ok(appoinment);
    }
}
