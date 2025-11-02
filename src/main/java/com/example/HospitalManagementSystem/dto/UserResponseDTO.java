package com.example.HospitalManagementSystem.dto;

import java.time.Instant;

public record UserResponseDTO(
        Long userId,
        String username,
        String role,
        boolean active,
        boolean deleted,
        Instant createdAt,
        Instant updatedAt
) {}
