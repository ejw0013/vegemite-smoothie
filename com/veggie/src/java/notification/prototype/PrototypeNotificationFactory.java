package com.veggie.src.java.notification.prototype;

import com.veggie.src.java.notification.AbstractNotificationFactory;
import com.veggie.src.java.notification.AbstractErrorNotification;
import com.veggie.src.java.notification.AbstractConfirmNotification;
import com.veggie.src.java.notification.AbstractSuccessNotification;

public class PrototypeNotificationFactory extends AbstractNotificationFactory {

  public AbstractNotificationFactory getInstance() {
      if (instance == null) {
          instance = new PrototypeNotificationFactory();
      }
      return instance;
  }

  public PrototypeErrorNotification createErrorNotification(String message) {
    return new PrototypeErrorNotification(message);
  }

  public PrototypeConfirmNotification createConfirmNotification(String message) {
    return new PrototypeConfirmNotification(message);
  }

  public PrototypeSuccessNotification createSuccessNotification(String message) {
    return new PrototypeSuccessNotification(message);
  }
}
