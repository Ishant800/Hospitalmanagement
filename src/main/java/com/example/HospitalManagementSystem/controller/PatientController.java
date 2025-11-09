package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.PatientDto;
import com.example.HospitalManagementSystem.dto.PatientResponseDto;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin("*")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDto patient){
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable UUID id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getallpatient(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }
}
