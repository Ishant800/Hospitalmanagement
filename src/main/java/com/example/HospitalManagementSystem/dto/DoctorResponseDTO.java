package com.example.HospitalManagementSystem.dto;

import java.time.Instant;
import java.util.UUID;

public record DoctorResponseDTO (
        Long doctorId,
        String name,
        String specialization

) {}
