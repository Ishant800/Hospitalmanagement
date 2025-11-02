package com.example.HospitalManagementSystem.ServiceImplementation;

import com.example.HospitalManagementSystem.dto.DoctorAppointmentDto;

import com.example.HospitalManagementSystem.entity.Doctor;
import com.example.HospitalManagementSystem.entity.DoctorAppointment;

import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.entity.enums.AppoinmentStatus;
import com.example.HospitalManagementSystem.repository.DappointmentRepo;
import com.example.HospitalManagementSystem.repository.DoctorRepo;
import com.example.HospitalManagementSystem.repository.PatientRepo;
import com.example.HospitalManagementSystem.service.DoctorAppoinmentService;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class DAppointmentServiceImpl implements DoctorAppoinmentService {

   private final PatientRepo patientRepo;
   private final DoctorRepo doctorRepo;
    private final DappointmentRepo repo;

    public DAppointmentServiceImpl(DappointmentRepo repo,DoctorRepo doctorRepo,PatientRepo patientRepo){
        this.repo = repo;
        this.doctorRepo = doctorRepo;
        this.patientRepo = patientRepo;
    }
    @Override
    public DoctorAppointment createAppointment(DoctorAppointmentDto dto) {
        Doctor doctor = doctorRepo.findById(dto.getDoctorId()).orElseThrow(()-> new RuntimeException("doctor not found"));
        Patient patient = patientRepo.findById(dto.getPatientId()).orElseThrow(()-> new RuntimeException("patient not found"));
        try {
            System.out.println(AppoinmentStatus.valueOf(dto.getStatus()));
            DoctorAppointment appointment = DoctorAppointment.builder()
                    .doctorId(doctor.getDoctorId())
                    .patientId(patient.getPatientId())
                    .notes(dto.getNotes())
                    .appoinmentStatus(AppoinmentStatus.valueOf(dto.getStatus()))
                    .build();

            return repo.save(appointment);
        } catch (Exception e) {
            e.printStackTrace(); // TEMP: see real root cause in console
            throw e; // rethrow so you still get the same 400
        }
    }


    @Override
    public DoctorAppointment getById(UUID id) {
        return null;
    }
}
