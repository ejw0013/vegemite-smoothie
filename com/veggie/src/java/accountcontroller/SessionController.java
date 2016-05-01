package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Account;
import com.veggie.src.java.Controller;
import com.veggie.src.java.notification.Notification;

public class SessionController implements Controller {
   private Notification notification;

   public void login(Account user) {

   }

   public void logout(Account user) {

   }

   public Notification getNotification() {
      return notification;
   }
}
