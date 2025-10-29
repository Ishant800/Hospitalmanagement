package com.example.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments",indexes = {
        @Index(columnList = "name",name = "idx_dept_name")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    @Column(nullable = false,unique = true,length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_doctor_id")
    private Doctor doctor;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private List<Doctor> doctors;
}
