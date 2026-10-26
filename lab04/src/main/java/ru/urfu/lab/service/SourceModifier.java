package ru.urfu.lab.service;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.util.*;

@org.springframework.stereotype.Service
@lombok.extern.slf4j.Slf4j
public class SourceModifier implements ModifyRequestService {
  public void modify(Request r) {
    r.setSource("service-1");
    log.info("request source changed uid={} source={}", r.getUid(), r.getSource());
  }
}
