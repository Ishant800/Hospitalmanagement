package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.Jwt.Jwtservice;
import com.example.HospitalManagementSystem.cloudinary.CloudinaryService;
import com.example.HospitalManagementSystem.dto.LoginDto;
import com.example.HospitalManagementSystem.dto.LoginResponseDto;
import com.example.HospitalManagementSystem.dto.UserDto;
import com.example.HospitalManagementSystem.entity.Patient;
import com.example.HospitalManagementSystem.entity.User;
import com.example.HospitalManagementSystem.entity.enums.Role;
import com.example.HospitalManagementSystem.repository.PatientRepo;
import com.example.HospitalManagementSystem.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class UserService {


    private final CloudinaryService cloudinaryService;
    private final UserRepo repo;
    private final  AuthenticationManager authenticationManager;
    private final Jwtservice jwtservice;

    private final PatientRepo patientRepo;

    private  final BCryptPasswordEncoder encoder;

    @Transactional
    public User createUser(UserDto dto , MultipartFile profileImage) throws IOException {
        User isExists = repo.findByUsername(dto.getUsername());
        if(isExists != null) throw new RuntimeException("user already Exists try another username");

        User isEmailExists = repo.findByEmail(dto.getEmail());
        if(isEmailExists != null) throw new RuntimeException("email already exists");

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        Role assignedRole;
        if (dto.getRole() != null) {
            try {
                assignedRole = Role.valueOf(dto.getRole().toString().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid role: " + dto.getRole());
            }
        } else {
            assignedRole = Role.PATIENT;
        }
        user.setRole(assignedRole);

        user.setEmail(dto.getEmail());

        if(profileImage != null && !profileImage.isEmpty()){
            Map uploadResult = cloudinaryService.uploadFile(profileImage);
            String imageUrl = uploadResult.get("secure_url").toString();
            user.setProfileImage(imageUrl);
        }
        User saveddata = repo.save(user);


        if(saveddata.getRole() == Role.PATIENT){
            Patient patient = new Patient();
            patient.setUser(user);
            patient.setPhone(null);
            patient.setGender(null);
            patient.setAge(null);
            patient.setAddress(null);
            patientRepo.save(patient);
        }


        return saveddata;

    }

    public LoginResponseDto login(LoginDto dto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword())
        );

       var user = repo.findByUsername(dto.getUsername());
        if(user == null){
            return null;
        }
        if(!encoder.matches(dto.getPassword(), user.getPassword())) return new LoginResponseDto("invalid password","");
        Map<String , Object> extraClaims = new HashMap<>();
        extraClaims.put("userId",user.getUserId());
        extraClaims.put("role",user.getRole().name());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole().name()))
        );
        String token = jwtservice.generateToken(extraClaims,userDetails);

        return new LoginResponseDto("login successfully",token);

    }

    public List<User> getalluser(){
        return repo.findAll();
    }
    public User getUserById(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("users not found"));
    }

//    public String getOtp(LoginDto dto){
//        User user = repo.findByUsername(dto.getEmail());
//        if(user == null) throw new RuntimeException("email not found");
//
//
//
//    }
}
