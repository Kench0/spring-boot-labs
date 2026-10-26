package ru.urfu.lab.dao;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

public interface DisciplineDAO {
  java.util.List<Discipline> all();

  java.util.Optional<Discipline> find(Long id);

  Discipline save(Discipline value);

  void delete(Long id);
}
