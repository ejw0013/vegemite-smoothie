package com.veggie.src.java.notification;

public class TomcatConfirmNotification extends AbstractConfirmNotification {
  private String message;

  protected TomcatConfirmNotification(String message) {
    this.message = message;
  }

  public String render() {
    return this.message;
  }
}
