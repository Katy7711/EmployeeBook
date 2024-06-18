package com.example.employeebook.service.impl;

import com.example.employeebook.entity.Employee;
import com.example.employeebook.repository.EmployeeProjection;
import com.example.employeebook.repository.EmployeeRepository;
import com.example.employeebook.service.EmployeeService;
import jakarta.validation.ValidationException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  @Override
  public EmployeeProjection getEmployeeById(long id) {
    return employeeRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Сотруник с id " + id + " не найден!"));
  }

  @Override
  public List<Employee> getEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee createEmployee(Employee employee) {
    if (employeeRepository.existsByFirstNameAndLastNameAndPosition(employee.getFirstName(),employee.getLastName(),employee.getPosition())) {
      throw new ValidationException(
          String.format("Сотрудник \"%s\" уже существует!", employee.getFirstName()));
    }
    return employeeRepository.save(employee);
  }

  @Override
  public Employee updateEmployee(String email, Employee employee) {
    Employee employee1 = employeeRepository.findById(employee.getId()).orElseThrow();
    employee1.setFirstName(employee.getFirstName());
    employee1.setLastName(employee.getLastName());
    employee1.setSalary(employee.getSalary());
    employee1.setPosition(employee.getPosition());
    employee1.setDepartment(employee.getDepartment());
    return employeeRepository.save(employee1);
  }

  @Override
  public boolean deleteEmployee(long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow();
    if (employeeRepository.existsById(id)) {
      employeeRepository.delete(employee);
      return true;
    }
    return false;
  }
}
