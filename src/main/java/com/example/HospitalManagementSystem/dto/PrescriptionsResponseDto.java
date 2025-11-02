package com.example.HospitalManagementSystem.dto;


import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionsResponseDto {
    private UUID patientId;
    private UUID appointmentId;
    private Long doctorId;
    private String diagnosis;
    private String medications;
    private UUID prescriptionId;
    private Instant issuedAt;


    public PrescriptionsResponseDto(UUID prescriptionId, Long doctorId, UUID patientId, String diagnosis, Instant createdAt, UUID appointmentId) {
    }


}
