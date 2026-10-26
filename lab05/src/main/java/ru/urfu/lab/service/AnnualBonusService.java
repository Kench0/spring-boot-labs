package ru.urfu.lab.service;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.util.*;

public interface AnnualBonusService {
  double calculate(Positions p, double salary, double bonus, int workDays, int year);

  double quarterly(Positions p, double salary, double bonus, int workDays, int year, int quarter);
}
