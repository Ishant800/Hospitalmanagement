package com.example.HospitalManagementSystem.dto;

import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppoinmentDto {
    private UUID patientId;
    private Long doctorId;
    private LocalDate date;
    private LocalTime time;
    private String notes;

}
