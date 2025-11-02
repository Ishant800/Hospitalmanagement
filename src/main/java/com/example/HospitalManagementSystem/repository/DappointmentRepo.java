package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Appoinment;
import com.example.HospitalManagementSystem.entity.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DappointmentRepo extends JpaRepository<DoctorAppointment, UUID> {
}
