package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entity.enums.AppoinmentStatus;
import java.time.Instant;
import java.util.UUID;

public record AppoinmentResponseDTO(
        UUID appoinmentId,
        Instant createdAt,
        Instant updatedAt,
        boolean deleted,
        AppoinmentStatus status,
        String reason,
        PatientResponseDto patient,
        DoctorResponseDTO doctor
) {

    }

