package com.example.HospitalManagementSystem.ServiceImplementation;

import com.example.HospitalManagementSystem.dto.AppoinmentDto;
import com.example.HospitalManagementSystem.entity.Appoinment;
import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.entity.enums.AppoinmentStatus;
import com.example.HospitalManagementSystem.repository.AppoinmentRepo;
import com.example.HospitalManagementSystem.repository.DoctorRepo;
import com.example.HospitalManagementSystem.repository.PatientRepo;
import com.example.HospitalManagementSystem.service.AppoinmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class AppoinmentServiceImplementation implements AppoinmetService {
    private final PatientRepo patientRepo;
    private final DoctorRepo doctorRepo;
   private  final AppoinmentRepo repo;


    @Autowired
    public AppoinmentServiceImplementation(AppoinmentRepo repo,DoctorRepo doctorRepo,PatientRepo patientRepo){
        this.doctorRepo = doctorRepo;
        this.patientRepo = patientRepo;
        this.repo = repo;
    }

    @Override

    public Appoinment createAppoinment(AppoinmentDto dto) {
        Doctor doctor = doctorRepo.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepo.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

//        System.out.println(patient);
//        System.out.println(doctor);
//        Appoinment appoinment = Appoinment.builder()
//                .doctor(doctor)
//                .patient(patient)
//                .notes(dto.getNotes())
//                .status(AppoinmentStatus.valueOf(dto.getAppoinmentstatus().toUpperCase()))
//                .appoinmentTime(Instant.now())
//                .build();
        Appoinment appoinment = new Appoinment();
        appoinment.setDoctor(doctor);
        appoinment.setPatient(patient);
        appoinment.setNotes(dto.getNotes());
        appoinment.setStatus(AppoinmentStatus.valueOf(dto.getAppoinmentstatus().toUpperCase()));
        appoinment.setAppoinmentTime(Instant.now());
        System.out.println(appoinment);
        return repo.save(appoinment);
    }

    @Override
    public List<Appoinment> getById(UUID id) {
        return List.of();
    }
}
