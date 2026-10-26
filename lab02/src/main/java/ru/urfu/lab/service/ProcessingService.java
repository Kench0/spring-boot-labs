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

  public ProcessingService(
      @Qualifier("timeModifier") ModifyResponseService time,
      @Qualifier("operationModifier") ModifyResponseService operation) {
    this.time = time;
    this.operation = operation;
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
    log.info("response completed {}", r);
    return r;
  }
}
