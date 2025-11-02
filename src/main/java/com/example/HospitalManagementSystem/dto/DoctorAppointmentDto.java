package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entity.enums.AppoinmentStatus;
import lombok.*;

import java.util.UUID;
@Data
@NoArgsConstructor
public class DoctorAppointmentDto {
    private UUID appointmentId;
    private String notes;
    private Long doctorId;
    private UUID patientId;
    private String status;
}
