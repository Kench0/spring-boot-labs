package ru.urfu.lab.dao;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

public interface StudentDAO {
  java.util.List<Student> all();

  java.util.Optional<Student> find(Long id);

  Student save(Student value);

  void delete(Long id);
}
