package com.example.HospitalManagementSystem.dto;

import com.example.HospitalManagementSystem.entity.enums.Role;
import lombok.Data;
@Data

public class UserDto {
    private Long userId;
    private String username;
    private String password;
    private Role role;
}
