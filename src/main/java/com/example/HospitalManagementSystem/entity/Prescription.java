package com.example.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "prescriptions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prescription extends BaseEntity{
    @Id
    @GeneratedValue
    private UUID prescriptionId ;



    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "dappoinment_id",nullable = false,unique = true)
    private DoctorAppointment dappoinment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(columnDefinition = "TEXT")
    private String diagnosis;

    @Column(columnDefinition = "TEXT")
    private String medications;

    private Instant issuedAt;

    @PrePersist
    public void onCreate() {
        this.issuedAt = Instant.now();
    }
}
