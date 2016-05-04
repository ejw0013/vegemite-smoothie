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
}
