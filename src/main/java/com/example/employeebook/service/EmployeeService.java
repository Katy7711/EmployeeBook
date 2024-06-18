package com.example.employeebook.service;

import com.example.employeebook.entity.Employee;
import com.example.employeebook.repository.EmployeeProjection;
import java.util.List;

public interface EmployeeService {

  EmployeeProjection getEmployeeById(long id);

  List<Employee> getEmployees();

  Employee createEmployee(Employee employee);

  Employee updateEmployee(String email, Employee employee);

  boolean deleteEmployee(long id);
}
