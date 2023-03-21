package net.joagz.employees_api.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.joagz.employees_api.models.Users;
import net.joagz.employees_api.repo.UserRepo;

public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserRepo repo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<Users> tempUser = repo.findByUsername(username);

    Users user = tempUser.get();

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    user.getAuthorities().stream().forEach(authority -> grantedAuthorities.add(
        new SimpleGrantedAuthority(authority.getAuthority())));

    return User.builder().username(user.getUsername()).password(user.getPassword()).authorities(grantedAuthorities)
        .disabled(!user.getEnabled()).build();

  }

}
