package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.AppoinmentDto;
import com.example.HospitalManagementSystem.entity.Appoinment;
import com.example.HospitalManagementSystem.service.AppoinmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppoinmentController {
    private final AppoinmetService appoinmetService;

    @Autowired
    public  AppoinmentController(AppoinmetService appoinmetService){
        this.appoinmetService = appoinmetService;
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppoinmentDto dto){
        return ResponseEntity.ok(appoinmetService.createAppoinment(dto));
    }
    @GetMapping
    public ResponseEntity<List<Appoinment>> getAppointmentByDoctor(@RequestParam Long doctorId){
        return ResponseEntity.ok(appoinmetService.getAppointmentsByDoctor(doctorId));
    }
}
