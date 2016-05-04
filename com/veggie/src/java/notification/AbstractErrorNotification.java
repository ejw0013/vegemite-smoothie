package com.veggie.src.java.notification;

public abstract class AbstractErrorNotification implements Notification {
  private boolean recieved;

  public final boolean ok() {
    return false;
  }

  public final boolean recieved() {
    return recieved;
  }

  public final void submit() {
    recieved = true;
  }
}
