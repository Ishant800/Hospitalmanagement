package com.example.HospitalManagementSystem.dto;

import lombok.*;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppoinmentDto {
    private UUID patientId;
    private Long doctorId;
    private String appoinmentstatus;
    private String notes;

}
