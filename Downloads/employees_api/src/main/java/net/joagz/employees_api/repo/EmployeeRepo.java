package net.joagz.employees_api.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import net.joagz.employees_api.models.Employee;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee, String> {

  Optional<Employee> findById(String id);

  Optional<List<Employee>> findByActive(Boolean active);

  Optional<List<Employee>> findByCreationDate(String creationDate);

  Optional<Employee> findByEmail(String email);

  Optional<List<Employee>> findByJobDesignation(String jobDesignation);

  Optional<List<Employee>> findByFullName(String fullName);

  Optional<List<Employee>> findByJobTitle(String jobTitle);

}
