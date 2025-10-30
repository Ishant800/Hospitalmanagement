package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.AppoinmentDto;
import com.example.HospitalManagementSystem.entity.Appoinment;

import java.util.List;
import java.util.UUID;

public interface AppoinmetService {
    Appoinment createAppoinment(AppoinmentDto dto);
    List<Appoinment> getById(UUID id);
}
