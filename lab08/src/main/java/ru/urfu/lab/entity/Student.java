package ru.urfu.lab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import ru.urfu.lab.config.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.dto.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@Entity
@Table(name = "students")
@Data
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 15)
  private String name;

  @NotBlank
  @Size(max = 25)
  private String surname;

  @NotBlank
  @Size(max = 20)
  private String faculty;

  @NotNull
  @Min(14)
  @Max(100)
  private Integer age;
}
