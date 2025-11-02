package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, UUID> {
    @Query("SELECT p FROM Prescription p " +
            "JOIN FETCH p.doctor " +
            "JOIN FETCH p.patient " +
            "JOIN FETCH p.dappoinment")
    List<Prescription> findAllWithDetails();
}
