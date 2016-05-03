package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Account;
import com.veggie.src.java.Controller;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;

public class AddFeeController implements Controller {
   private Notification notification;
   private Form addFeeForm;

   public AddFeeController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of User");
      builder.addField("Fee Amount");
      addFeeForm = builder.getResult();
   }

   public Form addFee() {
      return addFeeForm;
   }

   public Notification getNotification() {
      return notification;
   }
}
