package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.PatientDto;
import com.example.HospitalManagementSystem.dto.PatientResponseDto;
import com.example.HospitalManagementSystem.entity.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    Patient createPatient(PatientDto patient);
    PatientResponseDto getPatientById(UUID id);
    List<Patient> getAllPatients();
    Patient updatePatient(UUID id,Patient patient);
    void deletePatient(UUID id);
}
