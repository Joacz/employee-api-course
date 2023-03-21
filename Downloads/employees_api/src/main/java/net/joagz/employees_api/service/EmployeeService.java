package net.joagz.employees_api.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.joagz.employees_api.models.Employee;

public interface EmployeeService {

  Employee findById(String id);

  Page<Employee> findAll(Integer page);

  List<Employee> findByActive(Boolean active);

  List<Employee> findByCreationDate(String creationDate);

  Employee findByEmail(String email);

  List<Employee> findByJobDesignation(String jobDesignation);

  List<Employee> findByFullName(String fullName);

  List<Employee> findByJobTitle(String jobTitle);

}
