package com.example.HospitalManagementSystem.entity;

import com.example.HospitalManagementSystem.entity.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patients",indexes = {
        @Index(columnList = "phone",name = "idx_patient_phone")
})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID patientId;

    @OneToOne(fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "user_id",unique = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @Column(nullable = true,length = 150)
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Column(length = 20)
    private String phone;

    @Column(length = 255)
    private String address;

    @Email
    private String email;

    private LocalDate registeredAt;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private List<Appoinment> appoinments;

    @PrePersist
    public void onCreate(){
        this.registeredAt = LocalDate.now();
    }

}
