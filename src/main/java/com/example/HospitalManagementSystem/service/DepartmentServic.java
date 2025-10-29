package com.example.HospitalManagementSystem.service;

import com.example.HospitalManagementSystem.dto.DepartmentDto;
import com.example.HospitalManagementSystem.entity.Department;
import com.example.HospitalManagementSystem.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServic {
    @Autowired
    private DepartmentRepo repo;

    public Department createDepartment(DepartmentDto dto){
        Department department = new Department();
        department.setName(dto.getDeptname());
        department.setDescription(dto.getDescription());

        return repo.save(department);
    }

    public Department getDepartmentById(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("department not found"));
    }

    public List<Department> getDepartment(){
        return repo.findAll();
    }
}
