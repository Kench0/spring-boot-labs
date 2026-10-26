package ru.urfu.lab.service;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.util.*;

@org.springframework.stereotype.Service("timeModifier")
@lombok.extern.slf4j.Slf4j
public class TimeResponseModifier implements ModifyResponseService {
  public void modify(Response r) {
    r.setSystemTime(DateTimeUtil.now());
    log.info("response time updated uid={} time={}", r.getUid(), r.getSystemTime());
  }
}
