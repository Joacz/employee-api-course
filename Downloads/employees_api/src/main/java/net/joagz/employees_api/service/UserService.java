package net.joagz.employees_api.service;

import net.joagz.employees_api.models.Users;

public interface UserService {

  Users findById(Integer id);

  Users findByUsername(String username);

  Users findByEmail(String email);

}
