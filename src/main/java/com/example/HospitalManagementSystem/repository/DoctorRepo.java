package com.example.HospitalManagementSystem.repository;

import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
    Doctor findByUser(User user);
}
