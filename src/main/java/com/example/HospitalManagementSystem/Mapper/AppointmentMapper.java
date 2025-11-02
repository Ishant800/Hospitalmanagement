//package com.example.HospitalManagementSystem.Mapper;
//
//
//
//import com.example.HospitalManagementSystem.dto.*;
//
//import com.example.HospitalManagementSystem.entity.Appoinment;
//import com.example.HospitalManagementSystem.entity.Doctor;
//import com.example.HospitalManagementSystem.entity.Patient;
//
//public class AppointmentMapper {
//
//    public static AppoinmentResponseDTO toDto(Appoinment a) {
//        return new AppoinmentResponseDTO(
//                a.getAppoinmentId(),
//
//                a.getStatus(),
//                a.getCreatedAt(),
//                a.getUpdatedAt(),
//                mapPatient(a.getPatient()),
//                mapDoctor(a.getDoctor())
//        );
//    }
//
//    private static PatientSimpleDTO mapPatient(Patient p) {
//        if (p == null) return null;
//        return new PatientSimpleDTO(
//                p.getPatientId(),
//                p.getName(),
//                p.getEmail(),
//                p.getPhone()
//        );
//    }
//
//    private static DoctorSimpleDTO mapDoctor(Doctor d) {
//        if (d == null) return null;
//        return new DoctorSimpleDTO(
//                d.getDoctorId(),
//                d.getName(),
//                d.getSpecialization()
//        );
//    }
//}
