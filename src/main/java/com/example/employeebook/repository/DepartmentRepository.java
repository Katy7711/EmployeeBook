package com.example.employeebook.repository;

import com.example.employeebook.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department,Long> {

  boolean existsByName(String name);
}
