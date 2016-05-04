package com.veggie.src.java.controllers.account;

import com.veggie.src.java.core.Account;
import com.veggie.src.java.controllers.Controller;
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
