package com.veggie.src.java.app;

import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;


public interface Console {
    public void renderNotification(Notification notification);
    public void renderForm(Form form);
}
