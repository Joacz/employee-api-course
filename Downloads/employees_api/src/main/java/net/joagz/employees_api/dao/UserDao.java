package net.joagz.employees_api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.joagz.employees_api.models.Users;
import net.joagz.employees_api.repo.UserRepo;
import net.joagz.employees_api.service.UserService;

@Service
@AllArgsConstructor
public class UserDao implements UserService {

  @Autowired
  private final UserRepo repo;

  @Override
  public Users findByUsername(String username) {
    return repo.findByUsername(username).get();
  }

  @Override
  public Users findByEmail(String email) {
    return repo.findByEmail(email).get();
  }

  @Override
  public Users findById(Integer id) {
    return repo.findById(id).get();
  }

}
