package com.example.HospitalManagementSystem.entity;

import com.example.HospitalManagementSystem.entity.enums.AppoinmentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "appoinments")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appoinment extends BaseEntity{

    @Id
    @GeneratedValue
    private UUID appoinmentId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "doctor_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","user"})
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "patient_id",nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","user"})
    private Patient patient;

    @NotNull
    @Column(name = "appoinment_time",nullable = false)
    private Instant appoinmentTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private AppoinmentStatus status;

    @Column(columnDefinition = "TEXT")
    private String notes;



}
