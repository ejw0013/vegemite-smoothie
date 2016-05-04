package com.veggie.src.java.notification.prototype;

import com.veggie.src.java.notification.AbstractConfirmNotification;

public class PrototypeConfirmNotification extends AbstractConfirmNotification {
  private String message;

  protected PrototypeConfirmNotification(String message) {
    this.message = message;
  }

  public String toString() {
    return this.message;
  }

  public String render(String returnURI, String currentURI){
    currentURI = currentURI.substring(0, currentURI.length() - 1);
    currentURI += "2";
    StringBuilder sb = new StringBuilder();
    sb.append("<html><body>");
    sb.append(this.message);
    sb.append("<br>");
    sb.append("<a href=\"" + returnURI + "\">Go back to homepage</a><br>");
    sb.append("<a href=\"" + currentURI + "\">Confirm</a>");
    sb.append("</body></html>");
    return sb.toString();
  }

}
