package com.veggie.src.java.form;

public class TomcatFormBuilderFactory implements AbstractFormBuilderFactory {

  public TomcatFormBuilder createFormBuilder() {
    return new TomcatFormBuilder();
  }
}
