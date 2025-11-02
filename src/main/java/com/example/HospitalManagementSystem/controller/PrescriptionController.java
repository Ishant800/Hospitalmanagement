package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.PrescriptionDto;
import com.example.HospitalManagementSystem.entity.Prescription;
import com.example.HospitalManagementSystem.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService service;

    @PostMapping
    public ResponseEntity<Prescription> createpresc(@RequestBody PrescriptionDto dto){
        return ResponseEntity.ok(service.createPrescription(dto));
    }
}
