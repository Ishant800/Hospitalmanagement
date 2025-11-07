package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.EmailService.EmailSender;
import com.example.HospitalManagementSystem.Otp.OtpService;
import com.example.HospitalManagementSystem.dto.LoginDto;
import com.example.HospitalManagementSystem.dto.LoginResponseDto;
import com.example.HospitalManagementSystem.dto.UserDto;
import com.example.HospitalManagementSystem.entity.User;
import com.example.HospitalManagementSystem.entity.enums.Role;
import com.example.HospitalManagementSystem.repository.UserRepo;
import com.example.HospitalManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final OtpService otpService;
    private final EmailSender emailSender;
    private final UserRepo userRepo;

    private final BCryptPasswordEncoder encoder;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        return "Hello, " + authentication.getName() +
                " with roles " + authentication.getAuthorities();
    }

    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            @RequestParam(value = "profileImage",required = false)MultipartFile profileImage) throws IOException {
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setRole(Role.valueOf(role));
        return ResponseEntity.ok(service.createUser(userDto,profileImage));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getalluser(){
        return ResponseEntity.ok(service.getalluser());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto dto){
       return ResponseEntity.ok(service.login(dto));
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getuseById(@PathVariable Long id){
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PostMapping("/generate-otp")
    public ResponseEntity<String> generateOtp(@RequestParam String email){
        String otp = otpService.generateOtp(email);
        emailSender.sendOtp(email,otp);
        return ResponseEntity.ok("Otp Sent to your mail");
    }


    @PostMapping("/forgetPassword")
    public ResponseEntity<String> forgetPassword(@RequestParam String email,@RequestParam String otp,@RequestParam String confirmPassword){
        boolean validateOtp = otpService.validateOtp(email,otp);
        if(!validateOtp) throw new RuntimeException("Invalid otp! ");


        User user = userRepo.findByEmail(email);
        if(user == null){
            throw new RuntimeException("user not exists");
        }
        user.setPassword(encoder.encode(confirmPassword));
         userRepo.save(user);

         //delete otp from map(internal memory)
         otpService.invalidOtp(email);
        return ResponseEntity.ok("password update sucessfully");
    }


}
