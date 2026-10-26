package ru.urfu.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.urfu.lab.config.*;
import ru.urfu.lab.dto.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@Controller
@lombok.RequiredArgsConstructor
public class AuthController {
  private final UserService service;
  private final UserRepository users;

  @GetMapping({"/", "/index"})
  public String index() {
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/register")
  public String register(Model m) {
    m.addAttribute("user", new UserDto());
    return "register";
  }

  @PostMapping("/register/save")
  public String save(
      @jakarta.validation.Valid @ModelAttribute("user") UserDto user, BindingResult errors) {
    if (errors.hasErrors()) return "register";
    try {
      service.register(user);
    } catch (IllegalArgumentException e) {
      errors.rejectValue("email", "duplicate", e.getMessage());
      return "register";
    }
    return "redirect:/register?success";
  }

  @GetMapping("/users")
  public String users(Model m) {
    m.addAttribute("users", users.findAll());
    return "users";
  }
}
