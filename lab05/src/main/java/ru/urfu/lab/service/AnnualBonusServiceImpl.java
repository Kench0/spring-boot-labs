package ru.urfu.lab.service;

import java.time.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.util.*;

@org.springframework.stereotype.Service
public class AnnualBonusServiceImpl implements AnnualBonusService {
  private void validate(Positions p, double salary, double bonus, int workDays, int year) {
    if (p == null
        || !Double.isFinite(salary)
        || !Double.isFinite(bonus)
        || salary <= 0
        || bonus < 0
        || workDays <= 0
        || workDays > Year.of(year).length())
      throw new IllegalArgumentException("Invalid bonus arguments");
  }

  public double calculate(Positions p, double salary, double bonus, int workDays, int year) {
    validate(p, salary, bonus, workDays, year);
    return salary * bonus * Year.of(year).length() * p.getPositionCoefficient() / workDays;
  }

  public double quarterly(
      Positions p, double salary, double bonus, int workDays, int year, int quarter) {
    validate(p, salary, bonus, workDays, year);
    if (!p.isManager()) throw new IllegalArgumentException("Quarterly bonus is only for managers");
    if (quarter < 1 || quarter > 4) throw new IllegalArgumentException("Quarter must be 1..4");
    LocalDate start = LocalDate.of(year, 1 + (quarter - 1) * 3, 1);
    long days = java.time.temporal.ChronoUnit.DAYS.between(start, start.plusMonths(3));
    return salary * bonus * days * p.getPositionCoefficient() / workDays;
  }
}
