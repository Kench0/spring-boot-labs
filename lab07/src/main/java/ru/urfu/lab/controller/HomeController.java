package ru.urfu.lab.controller;

import ru.urfu.lab.entity.*;
import ru.urfu.lab.repository.*;

@org.springframework.stereotype.Controller
public class HomeController {
  @org.springframework.web.bind.annotation.GetMapping("/")
  public String home() {
    return "redirect:/list";
  }
}
