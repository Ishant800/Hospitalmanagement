package com.example.HospitalManagementSystem.Mapper;

import com.example.HospitalManagementSystem.dto.PatientResponseDto;
import com.example.HospitalManagementSystem.dto.UserResponseDTO;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.entity.User;

public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient) {
        return new PatientResponseDto(
                patient.getPatientId(),
                patient.getAge(),
                patient.getGender().toString(),
                patient.getPhone(),
                patient.getAddress(),
                patient.getRegisteredAt(),
                patient.isDeleted(),
                patient.getCreatedAt(),
                patient.getUpdatedAt(),
                mapUser(patient.getUser())
        );
    }

    private static UserResponseDTO mapUser(User user) {
        if (user == null) return null;
        return new UserResponseDTO(
                user.getUserId(),
                user.getUsername(),
                user.getRole().toString(),
                user.isActive(),
                user.isDeleted(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
