package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.Jwt.Jwtservice;
import com.example.HospitalManagementSystem.dto.LoginDto;
import com.example.HospitalManagementSystem.dto.LoginResponseDto;
import com.example.HospitalManagementSystem.dto.UserDto;
import com.example.HospitalManagementSystem.entity.User;
import com.example.HospitalManagementSystem.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepo repo;
    private final  AuthenticationManager authenticationManager;
    private final Jwtservice jwtservice;


    private  final BCryptPasswordEncoder encoder;

    public User createUser(UserDto dto){

        User isExists = repo.findByUsername(dto.getUsername());
        if(isExists != null) throw new RuntimeException("user already Exists try another username");

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        return repo.save(user);

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
}
