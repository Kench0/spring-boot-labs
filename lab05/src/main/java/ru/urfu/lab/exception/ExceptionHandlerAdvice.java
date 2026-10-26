package ru.urfu.lab.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

@RestControllerAdvice
@lombok.extern.slf4j.Slf4j
public class ExceptionHandlerAdvice {
  @ExceptionHandler({
    ValidationFailedException.class,
    org.springframework.http.converter.HttpMessageNotReadableException.class,
    IllegalArgumentException.class
  })
  public ResponseEntity<Response> validation(Exception e) {
    return error(e, 400, ErrorCodes.ValidationException, ErrorMessages.Validation);
  }

  @ExceptionHandler(UnsupportedCodeException.class)
  public ResponseEntity<Response> unsupported(Exception e) {
    return error(e, 422, ErrorCodes.UnsupportedCodeException, ErrorMessages.Unsupported);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Response> unknown(Exception e) {
    return error(e, 500, ErrorCodes.UnknownException, ErrorMessages.Unknown);
  }

  private ResponseEntity<Response> error(
      Exception e, int status, ErrorCodes code, ErrorMessages message) {
    log.error("request failed code={} reason={}", code, e.getMessage());
    Response r = new Response();
    r.setCode(Codes.failed);
    r.setErrorCode(code);
    r.setErrorMessage(message);
    r.setSystemTime(DateTimeUtil.now());
    r.setDetails(java.util.List.of(e.getMessage() == null ? "Error" : e.getMessage()));
    return ResponseEntity.status(status).body(r);
  }
}
