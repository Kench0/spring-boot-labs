package ru.urfu.lab.model;

import ru.urfu.lab.controller.*;
import ru.urfu.lab.exception.*;
import ru.urfu.lab.service.*;
import ru.urfu.lab.util.*;

public enum Systems {
  ERP("Enterprise Resource Planning"),
  CRM("Customer Relationship Management"),
  WMS("Warehouse Management System");
  public final String description;

  Systems(String description) {
    this.description = description;
  }
}
