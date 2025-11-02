package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.DoctorAppointmentDto;
import com.example.HospitalManagementSystem.entity.DoctorAppointment;

import java.util.UUID;

public interface DoctorAppoinmentService {
    DoctorAppointment createAppointment(DoctorAppointmentDto dto);
    DoctorAppointment getById(UUID id);
}
