package com.veggie.src.java.console.tomcat;

import com.veggie.src.java.console.Console;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;

public class TomcatConsole implements Console {
    public void renderNotification(Notification notification) {
        System.out.println(notification);
    }

    public void renderForm(Form form) {
        System.out.println(form);
    }
}
