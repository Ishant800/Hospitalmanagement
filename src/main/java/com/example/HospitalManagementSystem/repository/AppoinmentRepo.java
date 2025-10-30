package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface AppoinmentRepo extends JpaRepository<Appoinment, UUID> {
}
