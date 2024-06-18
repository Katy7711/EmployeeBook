package com.example.employeebook.entity;

import com.example.employeebook.repository.EmployeeProjection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "employees")
public class Employee implements EmployeeProjection {

  @Id
  private Long id;
  private String firstName;
  private String lastName;
  private String position;
  private int salary;
  @ManyToOne
  private Department department;

  @Override
  public String getDepartmentName() {
    return department.getName();
  }
}
