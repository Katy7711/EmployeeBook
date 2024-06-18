package com.example.employeebook.repository;

import com.example.employeebook.entity.Department;
import com.example.employeebook.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  List<EmployeeProjection> findByFirstName(String firstName);
  List<EmployeeProjection> findByPosition(String position);
  List<EmployeeProjection> findByDepartment(Department department);

  boolean existsByFirstNameAndLastNameAndPosition(String firstName, String lastname, String position);

}
