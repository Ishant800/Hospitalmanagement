package com.example.HospitalManagementSystem.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class Apierror {
    private final Instant timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

}
