package ru.urfu.lab.model;

import lombok.Data;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

@Data
public class Response {
  /** Идентификатор сообщения. */
  private String uid;

  /** Идентификатор операции. */
  private String operationUid;

  /** Время формирования ответа. */
  private String systemTime;

  /** Результат выполнения операции. */
  private Codes code = Codes.success;

  /** Машиночитаемый код ошибки. */
  private ErrorCodes errorCode = ErrorCodes.None;

  /** Сообщение об ошибке. */
  private ErrorMessages errorMessage = ErrorMessages.None;

  /** Детали ошибок валидации. */
  private java.util.List<String> details = java.util.List.of();

  /** Годовая премия. */
  private Double annualBonus;

  /** Квартальная премия управленца. */
  private Double quarterlyBonus;
}
