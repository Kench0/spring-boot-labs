package ru.urfu.lab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.repository.*;

@Entity
@Table(name = "study_groups")
@lombok.Data
public class StudyGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 30)
  private String name;

  @NotBlank
  @Size(max = 50)
  private String faculty;

  @NotNull
  @Min(1)
  @Max(6)
  private Integer course;
}
