package com.example.employeebook.service.impl;

import com.example.employeebook.entity.Department;
import com.example.employeebook.repository.DepartmentRepository;
import com.example.employeebook.service.DepartmentService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  @Override
  public Department createDepartment(Department department) {
    if (departmentRepository.existsByName(department.getName())) {
      throw new ValidationException(
          String.format("Департамент \"%s\" уже существует!", department.getName()));
    }
    return departmentRepository.save(department);
  }
}
