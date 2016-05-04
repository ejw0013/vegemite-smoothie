package com.veggie.src.java.notification;

public interface Notification {
  public boolean ok();
  public boolean recieved();
  public void submit();
  public String render(String returnURI, String currentURI);
}
