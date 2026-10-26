package ru.urfu.lab.util;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.model.*;
import ru.urfu.lab.service.*;

public final class DateTimeUtil {
  private DateTimeUtil() {}

  public static java.text.SimpleDateFormat getCustomFormat() {
    var format = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    format.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
    return format;
  }

  public static String now() {
    return getCustomFormat().format(new java.util.Date());
  }
}
