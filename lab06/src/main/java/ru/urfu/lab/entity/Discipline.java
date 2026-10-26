package ru.urfu.lab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.dao.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@Entity
@Table(name = "disciplines")
@Data
public class Discipline {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 100)
  private String name;

  @NotNull
  @Min(1)
  @Max(1000)
  private Integer hours;

  @NotBlank
  @Size(max = 100)
  private String teacher;
}
