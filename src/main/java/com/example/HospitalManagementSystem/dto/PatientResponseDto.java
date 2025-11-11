package com.example.HospitalManagementSystem.dto;


import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record PatientResponseDto(
        UUID patientId,

        Integer age,
        String gender,
        String phone,
        String address,

        LocalDate registeredAt,
        boolean deleted,
        Instant createdAt,
        Instant updatedAt,
        UserResponseDTO user
) {}
