package com.veggie.src.java.notification;

public class TomcatNotificationFactory extends AbstractNotificationFactory {

  public AbstractNotificationFactory getInstance() {
      if (instance == null) {
          instance = new TomcatNotificationFactory();
      }
      return instance;
  }

  public TomcatErrorNotification createErrorNotification(String message) {
    return new TomcatErrorNotification(message);
  }

  public TomcatConfirmNotification createConfirmNotification(String message) {
    return new TomcatConfirmNotification(message);
  }

  public TomcatSuccessNotification createSuccessNotification(String message) {
    return new TomcatSuccessNotification(message);
  }
}
