package com.veggie.src.java.database;

import java.util.Map;
import java.util.HashMap;

public class PrototypeDB {

  private Map<String, MediaTitle> titleTable;

  public PrototypeDB() {
    titleTable = new HashMap<>();
  }

  public Map<String, MediaTitle> getTitleTable() {
    return titleTable;
  }

}
