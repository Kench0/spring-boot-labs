package ru.urfu.lab.dto;

import jakarta.validation.constraints.*;
import ru.urfu.lab.config.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@lombok.Data
public class UserDto {
  @NotBlank private String firstName;
  @NotBlank private String lastName;
  @NotBlank @Email private String email;

  @NotBlank
  @Size(min = 8, max = 72)
  private String password;
}
