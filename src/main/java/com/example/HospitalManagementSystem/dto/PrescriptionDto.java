package com.example.HospitalManagementSystem.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {
    private Long doctorId;
    private UUID patientId;
    private UUID appoinmentId;
    private String diagnosis;
    private String medications;
}
