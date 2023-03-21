package net.joagz.employees_api.dto;

public record EmployeeDto(
    String full_name,
    String email,
    Integer age,
    String job_title,
    String job_designation,
    Boolean active) {

}
