package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.PrescriptionDto;
import com.example.HospitalManagementSystem.dto.PrescriptionsResponseDto;
import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.entity.DoctorAppointment;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.entity.Prescription;
import com.example.HospitalManagementSystem.repository.DappointmentRepo;
import com.example.HospitalManagementSystem.repository.DoctorRepo;
import com.example.HospitalManagementSystem.repository.PatientRepo;
import com.example.HospitalManagementSystem.repository.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {



    @Autowired
    private PrescriptionRepo repo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DappointmentRepo appointmentRepo;


    @Transactional
    public PrescriptionsResponseDto createPrescription(PrescriptionDto dto){
        Doctor doctor = doctorRepo.findById(dto.getDoctorId()).orElseThrow(()-> new RuntimeException("You are not allowed to create this !"));
        Patient patient = patientRepo.findById(dto.getPatientId()).orElseThrow(()-> new RuntimeException("patient not found check details !"));
        DoctorAppointment appointment = appointmentRepo.findById(dto.getAppoinmentId()).orElseThrow(()-> new RuntimeException("appoinment not found"));

        Prescription prescription = Prescription.builder()
                .dappoinment(appointment)
                .patient(patient)
                .doctor(doctor)
                .medications(dto.getMedications())
                .diagnosis(dto.getDiagnosis())
                .issuedAt(Instant.now()).build();

           Prescription prescription1 = repo.save(prescription);
        System.out.println(prescription1);
           return new PrescriptionsResponseDto(
                   prescription.getPrescriptionId(),
                   prescription.getDoctor().getDoctorId(),
                   prescription.getPatient().getPatientId(),
                   prescription.getDiagnosis(),
                   prescription.getCreatedAt(),
                   prescription.getDappoinment().getAppointmentId()
           );

    }

    @Transactional(readOnly = true)
    public List<PrescriptionsResponseDto> getallprescription(){
       return repo.findAllWithDetails().stream()
               .map(p -> new PrescriptionsResponseDto(
                       p.getPatient().getPatientId(),
                       p.getDappoinment().getAppointmentId(),
                       p.getDoctor().getDoctorId(),
                       p.getDiagnosis(),
                       p.getMedications(),
                       p.getPrescriptionId(),
                       p.getIssuedAt()
               ))
               .collect(Collectors.toList());
    }
}
