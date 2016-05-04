package com.veggie.src.java.form;

public class PrototypeFormBuilderFactory extends AbstractFormBuilderFactory {

  public static AbstractFormBuilderFactory getInstance() {
      if (instance == null) {
          instance = new PrototypeFormBuilderFactory();
      }
      return instance;
  }

  public PrototypeFormBuilder createFormBuilder() {
    return new PrototypeFormBuilder();
  }
}
