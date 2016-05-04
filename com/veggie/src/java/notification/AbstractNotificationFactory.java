package com.veggie.src.java.notification;

public abstract class AbstractNotificationFactory {
    protected AbstractNotificationFactory instance = null;

    public AbstractNotificationFactory getInstance() {
        return instance;
    }
    public abstract AbstractErrorNotification createErrorNotification(String message);
    public abstract AbstractSuccessNotification createSuccessNotification(String message);
    public abstract AbstractConfirmNotification createConfirmNotification(String message);
}
