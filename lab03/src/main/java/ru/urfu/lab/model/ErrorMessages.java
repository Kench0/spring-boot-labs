package ru.urfu.lab.model;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

public enum ErrorMessages {
  None(""),
  Unsupported("Не поддерживаемая ошибка"),
  Validation("Ошибка валидации"),
  Unknown("Произошла непредвиденная ошибка");
  private final String text;

  ErrorMessages(String text) {
    this.text = text;
  }

  @com.fasterxml.jackson.annotation.JsonValue
  public String text() {
    return text;
  }
}
