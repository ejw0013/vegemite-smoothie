package com.veggie.src.java.notification;

public class TomcatSuccessNotification extends AbstractSuccessNotification {
  private String message;

  protected TomcatSuccessNotification (String message) {
    this.message = message;
  }

  public String toString() {
    return this.message;
  }
}
