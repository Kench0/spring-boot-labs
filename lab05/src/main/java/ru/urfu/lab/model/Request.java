package ru.urfu.lab.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

@Data
public class Request {
  /** Уникальный идентификатор сообщения, до 32 символов. */
  @NotBlank
  @Size(max = 32)
  private String uid;

  /** Уникальный идентификатор операции, до 32 символов. */
  @NotBlank
  @Size(max = 32)
  private String operationUid;

  /** Необязательная система отправителя. */
  private Systems systemName;

  /** Обязательное время создания сообщения. */
  @NotBlank private String systemTime;

  /** Наименование ресурса. */
  private String source;

  /** Идентификатор коммуникации от 1 до 100000. */
  @NotNull
  @Min(1)
  @Max(100000)
  private Integer communicationId;

  /** Необязательный идентификатор шаблона. */
  private Integer templateId;

  /** Необязательный код продукта. */
  private Integer productCode;

  /** Необязательный код SMS. */
  private Integer smsCode;

  /** Должность сотрудника. */
  @NotNull private Positions position;

  /** Месячная заработная плата. */
  @NotNull @Positive private Double salary;

  /** Множитель премии. */
  @NotNull @PositiveOrZero private Double bonus;

  /** Число отработанных дней. */
  @NotNull @Positive private Integer workDays;

  /** Расчетный год. */
  @Min(1900)
  @Max(3000)
  private int year = 2024;

  /** Квартал от 1 до 4. */
  @Min(1)
  @Max(4)
  private int quarter = 1;
}
