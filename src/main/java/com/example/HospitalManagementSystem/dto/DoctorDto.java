package com.example.HospitalManagementSystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Data

@NoArgsConstructor
public class DoctorDto {


    @NotNull(message = "user Id must be provided")
    private Long userId;

    private String specialization;
    private String qualification;
    private String bio;
    private Integer experienceYears;
    private String phone;
    @NotNull(message = "department Id must be provided")
    private Long deptId;
    private LocalTime availableFrom;
    private LocalTime availableTo;
}
