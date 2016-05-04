package com.veggie.src.java.notification.prototype;

import com.veggie.src.java.notification.AbstractErrorNotification;

public class PrototypeErrorNotification extends AbstractErrorNotification {
  private String message;

  protected PrototypeErrorNotification (String message) {
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
  	sb.append("<a href=\"" + returnURI + "\">Go back</a>");
  	sb.append("</body></html>");
    return sb.toString();
  }
}
