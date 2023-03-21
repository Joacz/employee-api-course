package net.joagz.employees_api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.joagz.employees_api.models.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

  Optional<Users> findByUsername(String username);

  Optional<Users> findByEmail(String email);

}
