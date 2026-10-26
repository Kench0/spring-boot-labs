package ru.urfu.lab.dao;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@org.springframework.stereotype.Repository
@lombok.RequiredArgsConstructor
public class DisciplineDAOImpl implements DisciplineDAO {
  private final DisciplineRepository repository;

  public java.util.List<Discipline> all() {
    return repository.findAll();
  }

  public java.util.Optional<Discipline> find(Long id) {
    return repository.findById(id);
  }

  public Discipline save(Discipline value) {
    return repository.save(value);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
