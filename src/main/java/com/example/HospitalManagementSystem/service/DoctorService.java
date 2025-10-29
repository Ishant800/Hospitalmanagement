package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.DoctorDto;
import com.example.HospitalManagementSystem.entity.Department;
import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.entity.User;
import com.example.HospitalManagementSystem.repository.DepartmentRepo;
import com.example.HospitalManagementSystem.repository.DoctorRepo;
import com.example.HospitalManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public Doctor createDoctorProfile(DoctorDto dto){
        User user = userRepo.findById(dto.getUserId()).orElseThrow(()-> new RuntimeException("user not found please create user account first!"));

        Department department = departmentRepo.findById(dto.getDeptId()).orElseThrow(()-> new RuntimeException("department not exists"));
        Doctor doctor = new Doctor();
        doctor.setEmail(dto.getEmail());
        doctor.setName(dto.getName());
        doctor.setPhone(dto.getPhone());
        doctor.setQualification(dto.getQualification());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setUser(user);
        doctor.setDepartment(department);
        doctor.setAvailableFrom(dto.getAvailableFrom());
        doctor.setAvailableTo(dto.getAvailableTo());
        return repo.save(doctor);

    }
}
