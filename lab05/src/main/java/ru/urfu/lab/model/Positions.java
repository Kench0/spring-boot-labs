package ru.urfu.lab.model;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

public enum Positions {
  DEV(2.2, false),
  HR(1.2, false),
  TL(2.6, true),
  PO(2.8, true),
  TPM(3.0, true),
  CTO(3.5, true);
  private final double coefficient;
  private final boolean manager;

  Positions(double coefficient, boolean manager) {
    this.coefficient = coefficient;
    this.manager = manager;
  }

  public double getPositionCoefficient() {
    return coefficient;
  }

  public boolean isManager() {
    return manager;
  }
}
