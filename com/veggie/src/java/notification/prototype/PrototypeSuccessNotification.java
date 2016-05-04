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
}
