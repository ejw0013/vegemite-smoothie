package com.veggie.src.java.notification;

public class TomcatErrorNotification extends AbstractErrorNotification {
  private String message;

  protected TomcatErrorNotification (String message) {
    this.message = message;
  }

  public String toString() {
    return this.message;
  }
}
