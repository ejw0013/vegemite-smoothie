package com.veggie.src.java.notification;

public interface Notification {
  public boolean ok();
  public boolean recieved();
  public String render();
  public void submit();
}