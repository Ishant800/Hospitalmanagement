package com.example.HospitalManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @Column(length = 150)
    private String specialization;

    @Column(length = 150)
    private String qualification;


    @Column(length = 20)
    private String phone;

    private LocalTime availableFrom;
    private LocalTime availableTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @Column(length = 1000)
    private String bio;

    private Integer experienceYears;

//    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
//    private List<Appoinment> appoinments;

}
