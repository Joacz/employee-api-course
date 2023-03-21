package net.joagz.employees_api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.joagz.employees_api.models.Authorities;
import net.joagz.employees_api.repo.AuthoritiesRepo;
import net.joagz.employees_api.service.AuthorityService;

@Service
@AllArgsConstructor
public class AuthorityDao implements AuthorityService {

  @Autowired
  private final AuthoritiesRepo repo;

  @Override
  public Authorities findById(Integer id) {
    return repo.findById(id).get();
  }

  @Override
  public List<Authorities> findByAuthority(String authority) {
    return repo.findByAuthority(authority).get();
  }

}
