package ru.urfu.lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.dto.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@Configuration
public class SecurityConfig {
  @Bean
  public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
    return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filter(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(
            a ->
                a.requestMatchers(
                        "/",
                        "/index",
                        "/register",
                        "/register/save",
                        "/login",
                        "/style.css",
                        "/error")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .formLogin(f -> f.loginPage("/login").defaultSuccessUrl("/list", true).permitAll())
        .logout(l -> l.logoutSuccessUrl("/login?logout").permitAll())
        .build();
  }

  @Bean
  public org.springframework.boot.CommandLineRunner roles(RoleRepository repository) {
    return args -> {
      if (repository.findByName("ROLE_USER").isEmpty()) {
        Role role = new Role();
        role.setName("ROLE_USER");
        repository.save(role);
      }
    };
  }
}
