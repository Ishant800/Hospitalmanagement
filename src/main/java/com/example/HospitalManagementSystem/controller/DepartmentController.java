package com.example.HospitalManagementSystem.controller;

import com.example.HospitalManagementSystem.dto.DepartmentDto;
import com.example.HospitalManagementSystem.entity.Department;
import com.example.HospitalManagementSystem.service.DepartmentServic;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/department")
public class DepartmentController {

    @Autowired
    private DepartmentServic servic;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody DepartmentDto dto){
        Department department = servic.createDepartment(dto);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/{deptid}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long deptid){
        return ResponseEntity.ok(servic.getDepartmentById(deptid));
    }
    @GetMapping
    public ResponseEntity<List<Department>> getDepartment(){
        return ResponseEntity.ok(servic.getDepartment());
    }


}
