package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.Mapper.DoctorMapper;
import com.example.HospitalManagementSystem.dto.DoctorDto;
import com.example.HospitalManagementSystem.entity.Department;
import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.entity.User;
import com.example.HospitalManagementSystem.repository.DepartmentRepo;
import com.example.HospitalManagementSystem.repository.DoctorRepo;
import com.example.HospitalManagementSystem.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DepartmentRepo departmentRepo;


    private final DoctorMapper mapper;

    public DoctorService(DoctorMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional
    public Doctor createDoctorProfile(DoctorDto dto){
        User user = userRepo.findById(dto.getUserId()).orElseThrow(()-> new RuntimeException("user not found please create user account first!"));

        Department department = departmentRepo.findById(dto.getDeptId()).orElseThrow(()-> new RuntimeException("department not exists"));

        Doctor doctor = mapper.toEntity(dto);
        doctor.setUser(user);
        doctor.setDepartment(department);

        return repo.save(doctor);

    }

    public List<Doctor> getAlldoctors(){
        return repo.findAll();
    }
}
