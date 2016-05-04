package com.veggie.src.java.notification;

import com.veggie.src.java.notification.prototype.PrototypeNotificationFactory;

public abstract class AbstractNotificationFactory {
    protected static AbstractNotificationFactory instance = null;

    public static AbstractNotificationFactory getInstance() {
        if (instance == null) {
            instance = new PrototypeNotificationFactory();
        }
        return instance;
    }
    public abstract AbstractErrorNotification createErrorNotification(String message);
    public abstract AbstractSuccessNotification createSuccessNotification(String message);
    public abstract AbstractConfirmNotification createConfirmNotification(String message);
}
