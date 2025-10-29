package com.example.HospitalManagementSystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@NoArgsConstructor
public class DepartmentDto {
    @NotBlank(message = "department should be provided")
    private String deptname;
    private String description;

}
