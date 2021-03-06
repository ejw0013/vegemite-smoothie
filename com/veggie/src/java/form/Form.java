package com.veggie.src.java.form;

import java.util.List;

public interface Form {
  public List<String> getFieldNames();
  public List<String> getData();
  public void setData(List<String> data);
  public String render(String url);
}
