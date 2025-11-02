package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.PrescriptionDto;
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
    public Prescription createPrescription(PrescriptionDto dto){
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

        return repo.save(prescription);

    }
}
