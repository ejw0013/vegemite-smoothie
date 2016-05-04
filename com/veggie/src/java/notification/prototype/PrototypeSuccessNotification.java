package com.veggie.src.java.notification.prototype;

import com.veggie.src.java.notification.AbstractSuccessNotification;

public class PrototypeSuccessNotification extends AbstractSuccessNotification {
  private String message;

  protected PrototypeSuccessNotification (String message) {
    this.message = message;
  }

  public String toString() {
    return this.message;
  }

  public String render(String returnURI, String currentURI){
  StringBuilder sb = new StringBuilder();
  sb.append("<html><body>");
  sb.append(this.message);
  sb.append("<br>");
  sb.append("<a href=\"" + returnURI + "\">Go back to homepage</a>");
  sb.append("</body></html>");
   return sb.toString();
 }
}
