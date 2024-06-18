package com.example.employeebook.controller;

import com.example.employeebook.entity.Department;
import com.example.employeebook.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

  private final DepartmentService departmentService;
  @PostMapping("/add/department")
  public ResponseEntity<Department> addEmployee(@RequestBody Department department) {
    return ResponseEntity.ok(departmentService.createDepartment(department));
  }

}
