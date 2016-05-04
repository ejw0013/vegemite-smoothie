package com.veggie.src.java.controllers;

import com.veggie.src.java.form.Form;
import com.veggie.src.java.notification.Notification;

public interface Controller
{
    public Form activate();
    public Notification submitForm(Form form);
    public void respondToNotification(Notification notification);
}
