package com.example.HospitalManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;


import java.time.LocalTime;
@Entity
@Table(name = "doctors")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Doctor extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false,unique = true)
    private User user;

    @Column(nullable = true,length = 150)
    private String name;

    @Column(length = 150)
    private String specialization;

    @Column(length = 150)
    private String qualification;

    @Email
    private String email;

    @Column(length = 20)
    private String phone;

    private LocalTime availableFrom;
    private LocalTime availableTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("doctors")
    @JoinColumn(name = "department_id")
    private Department department;

//    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
//    private List<Appoinment> appoinments;

}
