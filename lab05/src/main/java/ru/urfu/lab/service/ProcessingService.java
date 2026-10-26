package ru.urfu.lab.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.util.*;

@Service
@lombok.extern.slf4j.Slf4j
public class ProcessingService {
  private final ModifyResponseService time, operation;
  private final AnnualBonusService bonus;

  public ProcessingService(
      @Qualifier("timeModifier") ModifyResponseService time,
      @Qualifier("operationModifier") ModifyResponseService operation,
      AnnualBonusService bonus) {
    this.time = time;
    this.operation = operation;
    this.bonus = bonus;
  }

  public Response process(Request q) {
    if ("123".equals(q.getUid())) {
      log.error("Unsupported uid={}", q.getUid());
      throw new UnsupportedCodeException();
    }
    Response r = new Response();
    r.setUid(q.getUid());
    r.setOperationUid(q.getOperationUid());
    time.modify(r);
    operation.modify(r);
    r.setAnnualBonus(
        bonus.calculate(
            q.getPosition(), q.getSalary(), q.getBonus(), q.getWorkDays(), q.getYear()));
    if (q.getPosition().isManager())
      r.setQuarterlyBonus(
          bonus.quarterly(
              q.getPosition(),
              q.getSalary(),
              q.getBonus(),
              q.getWorkDays(),
              q.getYear(),
              q.getQuarter()));
    log.info("response completed {}", r);
    return r;
  }
}
