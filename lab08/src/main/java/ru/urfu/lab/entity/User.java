package ru.urfu.lab.entity;

import jakarta.persistence.*;
import java.util.*;
import ru.urfu.lab.config.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.dto.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@Entity
@Table(name = "users")
@lombok.Getter
@lombok.Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();
}
