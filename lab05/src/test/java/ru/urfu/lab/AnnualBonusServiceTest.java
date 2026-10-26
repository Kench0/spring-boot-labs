package ru.urfu.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

class AnnualBonusServiceTest {
  final AnnualBonusService s = new AnnualBonusServiceImpl();

  @Test
  void ordinaryYear() {
    assertEquals(360493.8271604938, s.calculate(Positions.HR, 100000, 2, 243, 2023), 1e-6);
  }

  @Test
  void leapYear() {
    assertEquals(361481.4814814815, s.calculate(Positions.HR, 100000, 2, 243, 2024), 1e-6);
  }

  @Test
  void centuryIsNotLeap() {
    assertEquals(365, java.time.Year.of(2100).length());
  }

  @Test
  void managerQuarter() {
    assertEquals(194732.51028806585, s.quarterly(Positions.TL, 100000, 2, 243, 2024, 1), 1e-6);
  }

  @Test
  void ordinaryQuarter() {
    assertEquals(192592.59259259258, s.quarterly(Positions.TL, 100000, 2, 243, 2023, 1), 1e-6);
  }

  @Test
  void nonManagerRejected() {
    assertThrows(
        IllegalArgumentException.class, () -> s.quarterly(Positions.DEV, 100000, 2, 243, 2024, 1));
  }

  @Test
  void zeroDaysRejected() {
    assertThrows(
        IllegalArgumentException.class, () -> s.calculate(Positions.HR, 100000, 2, 0, 2024));
  }

  @Test
  void invalidQuarterRejected() {
    assertThrows(
        IllegalArgumentException.class, () -> s.quarterly(Positions.PO, 100000, 2, 243, 2024, 5));
  }

  @Test
  void allManagers() {
    for (Positions p : new Positions[] {Positions.TL, Positions.PO, Positions.TPM, Positions.CTO})
      assertTrue(s.quarterly(p, 100000, 2, 243, 2024, 2) > 0);
  }
}
