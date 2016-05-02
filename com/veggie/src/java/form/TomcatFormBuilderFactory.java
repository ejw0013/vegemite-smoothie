package com.veggie.src.java.form;

public class TomcatFormBuilderFactory extends AbstractFormBuilderFactory {

  public static AbstractFormBuilderFactory getInstance() {
      if (instance == null) {
          instance = new TomcatFormBuilderFactory();
      }
      return instance;
  }

  public TomcatFormBuilder createFormBuilder() {
    return new TomcatFormBuilder();
  }
}
