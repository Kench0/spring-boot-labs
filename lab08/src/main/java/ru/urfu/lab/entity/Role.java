package ru.urfu.lab.entity;

import jakarta.persistence.*;
import ru.urfu.lab.config.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.dto.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@Entity
@Table(name = "roles")
@lombok.Data
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;
}
