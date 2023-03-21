package net.joagz.employees_api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.joagz.employees_api.models.Employee;
import net.joagz.employees_api.repo.EmployeeRepo;
import net.joagz.employees_api.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeDao implements EmployeeService {

  @Autowired
  private final EmployeeRepo repo;

  @Override
  public List<Employee> findByActive(Boolean active) {
    return repo.findByActive(active).get();
  }

  @Override
  public List<Employee> findByCreationDate(String creationDate) {
    return repo.findByCreationDate(creationDate).get();
  }

  @Override
  public Employee findByEmail(String email) {
    return repo.findByEmail(email).get();
  }

  @Override
  public List<Employee> findByJobDesignation(String jobDesignation) {
    return repo.findByJobDesignation(jobDesignation).get();
  }

  @Override
  public List<Employee> findByFullName(String fullName) {
    return repo.findByFullName(fullName).get();
  }

  @Override
  public List<Employee> findByJobTitle(String jobTitle) {
    return repo.findByJobTitle(jobTitle).get();
  }

  @Override
  public Employee findById(String id) {

    return repo.findById(id).get();

  }

  @Override
  public Page<Employee> findAll(Integer page) {

    return repo.findAll(PageRequest.of(page, 5));

  }

}
