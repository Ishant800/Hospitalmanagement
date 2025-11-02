package com.example.HospitalManagementSystem.entity;

import com.example.HospitalManagementSystem.entity.enums.AppoinmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "DoctorAppointments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DoctorAppointment extends BaseEntity{
    @Id
    @GeneratedValue
    private UUID appointmentId;
    @Enumerated(EnumType.STRING)
    @Column(name = "appoinment_status", length = 20)
    private AppoinmentStatus appoinmentStatus;
    private UUID patientId;
    private Long doctorId;
    private String notes;

}
