package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.DoctorDto;
import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;


@RestController
@RequestMapping("/api/doctor")
@CrossOrigin("*")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody DoctorDto dto){
        Doctor doctor = service.createDoctorProfile(dto);
        return ResponseEntity.ok(doctor);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getallDoctor(){
        return ResponseEntity.ok(service.getAlldoctors());
    }
}
