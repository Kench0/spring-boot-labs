package ru.urfu.lab.repository;

import ru.urfu.lab.config.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.dto.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.service.*;

public interface RoleRepository
    extends org.springframework.data.jpa.repository.JpaRepository<Role, Long> {
  java.util.Optional<Role> findByName(String name);
}
