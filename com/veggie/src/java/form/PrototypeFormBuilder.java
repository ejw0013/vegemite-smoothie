package com.veggie.src.java.form;

import java.util.List;
import java.util.ArrayList;

public class PrototypeFormBuilder implements AbstractFormBuilder {
  private List<String> formFields;
  private List<String> defaultData;

  protected PrototypeFormBuilder() {
    formFields = new ArrayList<>();
    defaultData = new ArrayList<>();
  }

  public void addField(String fieldName) {
    formFields.add(fieldName);
    defaultData.add("");
  }

  public Form getResult() {
    return new PrototypeForm(formFields, defaultData);
  }
}
