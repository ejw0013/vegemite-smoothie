package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Account;
import com.veggie.src.java.Controller;
import com.veggie.src.java.notification.Notification;

public class PayFeeController implements Controller {
   private Notification notification;

   public void payFee(Account user, int amount) {

   }

   public Notification getNotification() {
      return notification;
   }
}
