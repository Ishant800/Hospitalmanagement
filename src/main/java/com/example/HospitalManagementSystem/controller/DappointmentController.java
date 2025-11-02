package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.DoctorAppointmentDto;
import com.example.HospitalManagementSystem.entity.DoctorAppointment;
import com.example.HospitalManagementSystem.service.DoctorAppoinmentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class DappointmentController {
    private final DoctorAppoinmentService service;

    @Autowired
    public DappointmentController(DoctorAppoinmentService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DoctorAppointment> createAppointment(@RequestBody DoctorAppointmentDto dto){
        return ResponseEntity.ok(service.createAppointment(dto));
    }
}
