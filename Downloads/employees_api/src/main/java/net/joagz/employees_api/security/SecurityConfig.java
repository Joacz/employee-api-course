package net.joagz.employees_api.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import net.joagz.employees_api.service.CustomUserDetailService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Bean
  BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  UserDetailsService customUserDetailsService() {
    return new CustomUserDetailService();
  }

  @Order(Ordered.HIGHEST_PRECEDENCE)
  @Bean
  SecurityFilterChain tokenSecurityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(
            auth -> {
              try {
                auth.and()
                    // .formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/",
                    // true).permitAll())
                    .formLogin(login -> login.permitAll())
                    .logout(logout -> logout.permitAll());

                auth.requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/fonts/**",
                    "/scss/**", "/files/**").permitAll();

                // auth.anyRequest().permitAll().and();
                auth.anyRequest().hasAnyAuthority("ADMIN", "SUPERVISOR");

              } catch (Exception e) {
                e.printStackTrace();
              }
            })
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)).build();
  }

  // @Bean
  // public UserDetailsManager users(DataSource dataSource) {
  // UserDetails user = User.withUsername("root")
  // .password(encoder().encode(
  // "1234"))
  // .roles("USER")
  // .build();
  // JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
  // users.createUser(user);
  // return users;
  // }

}
