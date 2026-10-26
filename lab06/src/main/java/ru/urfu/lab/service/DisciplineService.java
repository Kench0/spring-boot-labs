package ru.urfu.lab.service;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.dao.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.repository.*;

@org.springframework.stereotype.Service
@lombok.RequiredArgsConstructor
@org.springframework.transaction.annotation.Transactional
public class DisciplineService {
  private final DisciplineDAO dao;

  public java.util.List<Discipline> all() {
    return dao.all();
  }

  public Discipline get(Long id) {
    return dao.find(id)
        .orElseThrow(
            () ->
                new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Discipline not found"));
  }

  public Discipline create(Discipline value) {
    value.setId(null);
    return dao.save(value);
  }

  public Discipline update(Discipline value) {
    if (value.getId() == null)
      throw new org.springframework.web.server.ResponseStatusException(
          org.springframework.http.HttpStatus.BAD_REQUEST, "id required");
    get(value.getId());
    return dao.save(value);
  }

  public void delete(Long id) {
    get(id);
    dao.delete(id);
  }
}
