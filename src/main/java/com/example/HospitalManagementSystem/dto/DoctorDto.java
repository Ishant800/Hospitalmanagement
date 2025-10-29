package com.example.HospitalManagementSystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Data

@NoArgsConstructor
public class DoctorDto {


    private Long userId;
    private String name;
    private String specialization;
    private String qualification;
    private String email;
    private String phone;
    private Long deptId;
    private LocalTime availableFrom;
    private LocalTime availableTo;
}
