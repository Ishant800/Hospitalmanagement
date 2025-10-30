package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepo  extends JpaRepository<Patient, UUID> {
}
