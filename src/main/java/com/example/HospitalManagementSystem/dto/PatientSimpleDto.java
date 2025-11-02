package com.example.HospitalManagementSystem.dto;

import java.util.UUID;

public record PatientSimpleDto(
        UUID patientId,
        String name,
        String email,
        String phone
) { }
