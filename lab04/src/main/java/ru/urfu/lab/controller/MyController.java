package ru.urfu.lab.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

@RestController
@lombok.RequiredArgsConstructor
@lombok.extern.slf4j.Slf4j
public class MyController {
  private final ProcessingService processor;
  private final ForwardService forward;

  @PostMapping("/feedback")
  public Response handle(@Valid @RequestBody Request request, BindingResult errors) {
    long received = System.currentTimeMillis();
    log.info("request received {}", request);
    if (errors.hasErrors()) {
      String messages =
          errors.getFieldErrors().stream()
              .map(e -> e.getField() + ": " + e.getDefaultMessage())
              .sorted()
              .collect(java.util.stream.Collectors.joining("; "));
      log.error("bindingResult {}", messages);
      throw new ValidationFailedException(messages);
    }
    forward.send(request, received);
    return processor.process(request);
  }
}
