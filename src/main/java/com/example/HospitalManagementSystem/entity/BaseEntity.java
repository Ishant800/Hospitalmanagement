package com.example.HospitalManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity {
    @CreatedDate
    @Column(name = "created_at",nullable = false,updatable = false)
    protected Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected Instant updatedAt;

    @Column(name = "deleted",nullable = false)
    protected boolean deleted = false;


}
