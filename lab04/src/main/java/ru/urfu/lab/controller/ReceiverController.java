package ru.urfu.lab.controller;

import org.springframework.web.bind.annotation.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

@RestController
@lombok.extern.slf4j.Slf4j
public class ReceiverController {
  @PostMapping("/receive")
  public java.util.Map<String, Object> receive(
      @RequestBody Request request, @RequestHeader("X-Received-At") long received) {
    long elapsed = System.currentTimeMillis() - received;
    log.info(
        "service-2 received uid={} source={} elapsedMs={}",
        request.getUid(),
        request.getSource(),
        elapsed);
    return java.util.Map.of(
        "uid", request.getUid(), "source", request.getSource(), "elapsedMs", elapsed);
  }
}
