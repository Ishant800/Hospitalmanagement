package com.example.HospitalManagementSystem.Mapper;

import com.example.HospitalManagementSystem.dto.DoctorDto;
import com.example.HospitalManagementSystem.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public Doctor toEntity(DoctorDto dto){
        return Doctor.builder()
                .phone(dto.getPhone())
                .experienceYears(dto.getExperienceYears())
                .qualification(dto.getQualification())
                .specialization(dto.getSpecialization())
                .bio(dto.getBio())
                .availableFrom(dto.getAvailableFrom())
                .availableTo(dto.getAvailableTo())
                .build();
    }
}
