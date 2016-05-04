package com.veggie.src.java.form;

import java.util.List;

public class PrototypeForm implements Form {
  private List<String> data;
  private List<String> fieldNames;

  protected PrototypeForm(List<String> fieldNames, List<String> defaultData) {
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

  public String render(String url) {
    url = url.substring(0, url.length() - 1);
    url += "1";
    StringBuilder sb =new StringBuilder();
    sb.append("<form method=\"post\" action=\"" + url + "\">");
    for(String fieldName : fieldNames){
      sb.append(fieldName + ":<br>");
      sb.append("<input type=\"text\" name=\""+ fieldName + "\">");
    }
    sb.append("<input type=\"submit\" value=\"Submit\">");
    sb.append("</form>");
    return sb.toString();
  }
}
