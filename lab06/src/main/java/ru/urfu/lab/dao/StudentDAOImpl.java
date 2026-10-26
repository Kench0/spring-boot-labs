package ru.urfu.lab.dao;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@org.springframework.stereotype.Repository
@lombok.RequiredArgsConstructor
public class StudentDAOImpl implements StudentDAO {
  private final StudentRepository repository;

  public java.util.List<Student> all() {
    return repository.findAll();
  }

  public java.util.Optional<Student> find(Long id) {
    return repository.findById(id);
  }

  public Student save(Student value) {
    return repository.save(value);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
