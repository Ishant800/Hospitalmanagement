package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.PrescriptionDto;
import com.example.HospitalManagementSystem.dto.PrescriptionsResponseDto;

import com.example.HospitalManagementSystem.entity.Prescription;
import com.example.HospitalManagementSystem.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService service;

    @PostMapping
    public ResponseEntity<PrescriptionsResponseDto> createpresc(@RequestBody PrescriptionDto dto){
        return ResponseEntity.ok(service.createPrescription(dto));
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionsResponseDto>> getallprescription(){
        return ResponseEntity.ok(service.getallprescription());
    }
}
