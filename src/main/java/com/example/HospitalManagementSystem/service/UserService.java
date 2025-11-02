package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.UserDto;
import com.example.HospitalManagementSystem.entity.User;
import com.example.HospitalManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepo repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User createUser(UserDto dto){

        User isExists = repo.findByUsername(dto.getUsername());
        if(isExists != null) throw new RuntimeException("user already Exists try another username");

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        return repo.save(user);

    }

    public String login(UserDto dto){
        User user = repo.findByUsername(dto.getUsername());
        if(user == null){
            return "user not found";
        }
        if(!encoder.matches(dto.getPassword(), user.getPassword())) return "invalid password";
        return "user login sucessfully";

    }

    public List<User> getalluser(){
        return repo.findAll();
    }
    public User getUserById(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("users not found"));
    }
}
