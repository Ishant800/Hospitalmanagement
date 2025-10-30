package com.example.HospitalManagementSystem.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long userId;

    private UUID patientId;
private String email;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private String phone;
    private UUID appoinmentId;

}
