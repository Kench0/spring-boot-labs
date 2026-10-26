package ru.urfu.lab.service;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.util.*;

@org.springframework.stereotype.Service("operationModifier")
@lombok.extern.slf4j.Slf4j
public class OperationResponseModifier implements ModifyResponseService {
  public void modify(Response r) {
    r.setOperationUid(r.getOperationUid() + "-processed");
    log.info("response operation updated uid={} operation={}", r.getUid(), r.getOperationUid());
  }
}
