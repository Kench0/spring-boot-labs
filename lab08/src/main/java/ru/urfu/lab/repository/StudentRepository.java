package ru.urfu.lab.repository;

import ru.urfu.lab.config.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.dto.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.service.*;

public interface StudentRepository
    extends org.springframework.data.jpa.repository.JpaRepository<Student, Long> {}
