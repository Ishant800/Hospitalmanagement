package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.awt.*;
import java.util.List;
import java.util.UUID;

public interface AppoinmentRepo extends JpaRepository<Appoinment, UUID> {
    List<Appoinment> findByDoctor_DoctorId(Long doctorId);
    List<Appoinment> findByPatient_PatientId(UUID patientId);

}
