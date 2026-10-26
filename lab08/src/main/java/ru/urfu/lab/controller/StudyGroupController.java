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
public class StudyGroupController {
  private final StudyGroupRepository repository;

  @GetMapping("/groups")
  public String list(Model m) {
    m.addAttribute("items", repository.findAll());
    return "group-list";
  }

  @GetMapping("/addGroupForm")
  public String add(Model m) {
    m.addAttribute("item", new StudyGroup());
    return "group-form";
  }

  @GetMapping("/showGroupUpdateForm")
  public String edit(@RequestParam Long groupId, Model m) {
    m.addAttribute(
        "item",
        repository
            .findById(groupId)
            .orElseThrow(
                () ->
                    new org.springframework.web.server.ResponseStatusException(
                        org.springframework.http.HttpStatus.NOT_FOUND)));
    return "group-form";
  }

  @PostMapping("/saveGroup")
  public String save(@Valid @ModelAttribute("item") StudyGroup item, BindingResult errors) {
    if (errors.hasErrors()) return "group-form";
    if (item.getId() != null && !repository.existsById(item.getId()))
      throw new org.springframework.web.server.ResponseStatusException(
          org.springframework.http.HttpStatus.NOT_FOUND);
    repository.save(item);
    return "redirect:/groups";
  }

  @PostMapping("/deleteGroup")
  public String delete(@RequestParam Long groupId) {
    repository.deleteById(groupId);
    return "redirect:/groups";
  }
}
