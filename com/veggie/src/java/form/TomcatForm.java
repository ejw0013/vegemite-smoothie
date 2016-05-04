package com.veggie.src.java.form;

import java.util.List;

public class TomcatForm implements Form {
  private List<String> data;
  private List<String> fieldNames;

  protected TomcatForm(List<String> fieldNames, List<String> defaultData) {
    this.fieldNames = fieldNames;
    this.data = defaultData;
  }

  public String toString() {
    String out = "";
    for (int i = 0; i < fieldNames.size(); i++) {
        out += fieldNames.get(i) + ": " + data.get(i) + "\n";
    }
    return out;
  }

  public List<String> getFieldNames() {
    return fieldNames;
  }

  public List<String> getData() {
    return data;
  }
}
