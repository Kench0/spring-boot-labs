package ru.urfu.lab.exception;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

public class ValidationFailedException extends RuntimeException {
  public ValidationFailedException(String message) {
    super(message);
  }
}
