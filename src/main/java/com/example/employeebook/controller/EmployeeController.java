package com.example.employeebook.controller;

import com.example.employeebook.entity.Employee;
import com.example.employeebook.repository.EmployeeProjection;
import com.example.employeebook.service.impl.EmployeeServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;


    @GetMapping("employee/{id}")
    public ResponseEntity<EmployeeProjection> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok(employeeServiceImpl.getEmployeeById(id));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeServiceImpl.getEmployees());
    }

    @PostMapping("/add/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.createEmployee(employee));
    }

    @PatchMapping("/update/employee")
    public ResponseEntity<Employee> updateEmployee(String email, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceImpl.updateEmployee(email, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeEmployee(@PathVariable long id) {
        if (employeeServiceImpl.deleteEmployee(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).build();
    }
  
    }
