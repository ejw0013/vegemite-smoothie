package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Account;
import com.veggie.src.java.Controller;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.notification.Notification;

public class SessionController implements Controller {
   private Notification notification;

   public void login(Account user) {

   }

   public Form activate() {
       return null;
   }

   public void logout(Account user) {

   }

   public Notification getNotification() {
      return notification;
   }
}
