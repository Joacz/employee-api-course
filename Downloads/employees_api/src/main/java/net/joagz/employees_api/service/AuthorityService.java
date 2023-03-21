package net.joagz.employees_api.service;

import java.util.List;

import net.joagz.employees_api.models.Authorities;

public interface AuthorityService {

  Authorities findById(Integer id);

  List<Authorities> findByAuthority(String authority);

}
