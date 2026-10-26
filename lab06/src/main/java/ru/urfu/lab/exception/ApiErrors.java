package ru.urfu.lab.exception;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.dao.*;
import ru.urfu.lab.entity.*;
import ru.urfu.lab.repository.*;
import ru.urfu.lab.service.*;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class ApiErrors {
  @org.springframework.web.bind.annotation.ExceptionHandler(
      org.springframework.web.server.ResponseStatusException.class)
  public org.springframework.http.ResponseEntity<?> missing(
      org.springframework.web.server.ResponseStatusException e) {
    return org.springframework.http.ResponseEntity.status(e.getStatusCode())
        .body(java.util.Map.of("success", false, "message", e.getReason()));
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(
      org.springframework.web.bind.MethodArgumentNotValidException.class)
  public org.springframework.http.ResponseEntity<?> invalid(
      org.springframework.web.bind.MethodArgumentNotValidException e) {
    return org.springframework.http.ResponseEntity.badRequest()
        .body(
            java.util.Map.of(
                "success",
                false,
                "message",
                e.getBindingResult().getFieldErrors().stream()
                    .map(x -> x.getField() + ": " + x.getDefaultMessage())
                    .toList()));
  }
}
