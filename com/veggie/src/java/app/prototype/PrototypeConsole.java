package com.veggie.src.java.app.prototype;

import com.veggie.src.java.app.Console;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;

public class PrototypeConsole implements Console {
    public void renderNotification(Notification notification) {
        System.out.println(notification);
    }

    public void renderForm(Form form) {
        System.out.println(form);
    }
}
