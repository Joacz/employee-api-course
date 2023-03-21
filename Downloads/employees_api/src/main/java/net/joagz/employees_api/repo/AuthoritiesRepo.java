package net.joagz.employees_api.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.joagz.employees_api.models.Authorities;

public interface AuthoritiesRepo extends JpaRepository<Authorities, Integer> {

  Optional<List<Authorities>> findByAuthority(String authority);

}
