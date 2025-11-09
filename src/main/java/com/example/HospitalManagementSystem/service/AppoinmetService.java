package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.AppoinmentDto;
import com.example.HospitalManagementSystem.entity.Appoinment;
import com.example.HospitalManagementSystem.entity.enums.AppoinmentStatus;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

public interface AppoinmetService {
    @Transactional
    Appoinment createAppoinment(AppoinmentDto dto);


    List<Appoinment> getAppointmentsByDoctor(Long doctorId);
    List<Appoinment> getAppointmentsByPatient(UUID patientId);
    Appoinment updateStatus(UUID id, AppoinmentStatus status);

    List<Appoinment> getallAppointment();
}
