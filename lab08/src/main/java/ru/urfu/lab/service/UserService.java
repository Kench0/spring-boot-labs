package ru.urfu.lab.service;

import ru.urfu.lab.config.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.dto.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.repository.*;

@org.springframework.stereotype.Service
@lombok.RequiredArgsConstructor
public class UserService
    implements org.springframework.security.core.userdetails.UserDetailsService {
  private final UserRepository users;
  private final RoleRepository roles;
  private final org.springframework.security.crypto.password.PasswordEncoder encoder;

  @org.springframework.transaction.annotation.Transactional
  public void register(UserDto dto) {
    String email = dto.getEmail().trim().toLowerCase(java.util.Locale.ROOT);
    if (users.existsByEmail(email)) throw new IllegalArgumentException("Email уже зарегистрирован");
    User u = new User();
    u.setFirstName(dto.getFirstName());
    u.setLastName(dto.getLastName());
    u.setEmail(email);
    u.setPassword(encoder.encode(dto.getPassword()));
    u.getRoles().add(roles.findByName("ROLE_USER").orElseThrow());
    users.save(u);
  }

  public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(
      String email) {
    User u =
        users
            .findByEmail(email.trim().toLowerCase(java.util.Locale.ROOT))
            .orElseThrow(
                () ->
                    new org.springframework.security.core.userdetails.UsernameNotFoundException(
                        "User not found"));
    return org.springframework.security.core.userdetails.User.withUsername(u.getEmail())
        .password(u.getPassword())
        .authorities(u.getRoles().stream().map(Role::getName).toArray(String[]::new))
        .build();
  }
}
