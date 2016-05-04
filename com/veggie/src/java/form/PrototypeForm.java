package com.veggie.src.java.form;

import java.util.List;

public class PrototypeForm implements Form {
  private List<String> data;
  private List<String> fieldNames;

  public PrototypeForm(List<String> fieldNames, List<String> defaultData) {
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

  public void setData(List<String> data) {
      this.data = data;
  }

  public String render(String url) {

    url = url.substring(0, url.length() - 1);
    url += "1";

    if (fieldNames.size() == 0) {
      StringBuilder response = new StringBuilder();
      response.append("<html><script>");
      response.append("window.location = \"" + url + "\"");
      response.append("</script></html>");
      return response.toString();
    } else {
      StringBuilder sb =new StringBuilder();
      sb.append("<html><body>");
      sb.append("<form method=\"post\" action=\"" + url + "\">");
      for(String fieldName : fieldNames){
        sb.append(fieldName + ":<br>");
        sb.append("<input type=\"text\" name=\""+ fieldName + "\"><br>");
      }
      sb.append("<input type=\"submit\" value=\"Submit\">");
      sb.append("</form>");
      sb.append("</body></html>");
      return sb.toString();
    }
  }
}
