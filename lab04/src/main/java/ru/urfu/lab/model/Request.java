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
}
