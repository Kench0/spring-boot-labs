package ru.urfu.lab.controller;

import jakarta.validation.Valid;
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
public class StudentController {
  private final StudentRepository repository;

  @GetMapping("/list")
  public String list(Model m) {
    m.addAttribute("items", repository.findAll());
    return "student-list";
  }

  @GetMapping("/addStudentForm")
  public String add(Model m) {
    m.addAttribute("item", new Student());
    return "student-form";
  }

  @GetMapping("/showUpdateForm")
  public String edit(@RequestParam Long studentId, Model m) {
    m.addAttribute(
        "item",
        repository
            .findById(studentId)
            .orElseThrow(
                () ->
                    new org.springframework.web.server.ResponseStatusException(
                        org.springframework.http.HttpStatus.NOT_FOUND)));
    return "student-form";
  }

  @PostMapping("/saveStudent")
  public String save(@Valid @ModelAttribute("item") Student item, BindingResult errors) {
    if (errors.hasErrors()) return "student-form";
    if (item.getId() != null && !repository.existsById(item.getId()))
      throw new org.springframework.web.server.ResponseStatusException(
          org.springframework.http.HttpStatus.NOT_FOUND);
    repository.save(item);
    return "redirect:/list";
  }

  @PostMapping("/deleteStudent")
  public String delete(@RequestParam Long studentId) {
    repository.deleteById(studentId);
    return "redirect:/list";
  }
}
