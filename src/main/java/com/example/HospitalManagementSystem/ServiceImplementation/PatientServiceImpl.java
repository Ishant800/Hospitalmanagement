package com.example.HospitalManagementSystem.ServiceImplementation;

import com.example.HospitalManagementSystem.dto.PatientDto;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.entity.enums.Gender;
import com.example.HospitalManagementSystem.repository.PatientRepo;
import com.example.HospitalManagementSystem.repository.UserRepo;
import com.example.HospitalManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;

    private final UserRepo userRepo;


    @Autowired
    public PatientServiceImpl(PatientRepo patientRepo,UserRepo userRepo){
        this.patientRepo = patientRepo;
        this.userRepo = userRepo;
    }


    @Override
    public Patient createPatient(PatientDto patient) {

        Patient patient1 = new Patient();
        patient1.setUser(userRepo.findById(patient.getUserId()).get());
        patient1.setName(patient.getName());
        patient1.setEmail(patient.getEmail());
        patient1.setGender(Gender.valueOf(patient.getGender()));
        patient1.setPhone(patient.getPhone());
        patient1.setAddress(patient.getAddress());
        patient1.setAge(patient.getAge());
        return patientRepo.save(patient1);
    }

    @Override
    public Patient getPatientById(UUID id) {
        return patientRepo.findById(id).orElseThrow(()-> new RuntimeException("user not found please try again"));
    }

    @Override
    public List<Patient> getAllPatients() {
        return List.of();
    }

    @Override
    public Patient updatePatient(UUID id, Patient patient) {
        Patient patient1 = patientRepo.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
        Patient patient2 = new Patient();
        patient2.setName(patient.getName());
        patient2.setEmail(patient.getEmail());
        patient2.setPhone(patient.getPhone());
        patient2.setGender(patient.getGender());
        patient2.setAge(patient.getAge());

        return patientRepo.save(patient2);
    }

    @Override
    public void deletePatient(UUID id) {

        Patient patient = getPatientById(id);
        patientRepo.delete(patient);

    }
}
