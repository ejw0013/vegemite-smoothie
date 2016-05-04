package com.veggie.src.java.notification;

public abstract class AbstractConfirmNotification implements Notification {
  private boolean recieved;
  private boolean confirmed;


  public final boolean ok() {
    return confirmed && recieved;
  }

  public final void confirm() {
    confirmed = true;
  }

  public final boolean recieved() {
    return recieved;
  }

  public final void submit() {
    recieved = true;
  }

  public abstract String render(String returnURI);
}
