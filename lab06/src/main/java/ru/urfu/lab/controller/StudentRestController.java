package ru.urfu.lab.controller;

import java.util.Map;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.urfu.lab.dao.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@RestController
@RequestMapping("/api/students")
@lombok.RequiredArgsConstructor
public class StudentRestController {
  private final StudentService service;

  @GetMapping
  public Map<String, Object> all() {
    return Map.of("success", true, "data", service.all());
  }

  @GetMapping("/{id}")
  public Map<String, Object> get(@PathVariable Long id) {
    return Map.of("success", true, "data", service.get(id));
  }

  @PostMapping
  public ResponseEntity<?> create(@jakarta.validation.Valid @RequestBody Student value) {
    return ResponseEntity.status(201).body(Map.of("success", true, "data", service.create(value)));
  }

  @PutMapping
  public Map<String, Object> update(@jakarta.validation.Valid @RequestBody Student value) {
    return Map.of("success", true, "data", service.update(value));
  }

  @DeleteMapping("/{id}")
  public Map<String, Object> delete(@PathVariable Long id) {
    service.delete(id);
    return Map.of("success", true, "deletedId", id);
  }
}
