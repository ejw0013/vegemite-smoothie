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
}
