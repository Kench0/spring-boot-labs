package ru.urfu.lab.repository;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.entity.*;

public interface StudentRepository
    extends org.springframework.data.jpa.repository.JpaRepository<Student, Long> {}
