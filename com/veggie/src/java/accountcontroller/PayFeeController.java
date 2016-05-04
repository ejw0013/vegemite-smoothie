package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Account;
import com.veggie.src.java.Controller;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.AccountDatabaseManager;

import java.util.List;
import java.util.ArrayList;

public class PayFeeController implements Controller {
   private Notification notification;
   private Form payFeeForm;
   private AccountDatabaseManager manager;

   public PayFeeController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of User");
      builder.addField("Payment Amount");
      payFeeForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }
   
   public Form payFee() {
      return payFeeForm;
   }

   public Notification getNotification(Form form) {
      payFeeForm = form;
      List<String> formData = payFeeForm.getData();
      double change = manager.payFee(Integer.parseInt(formData.get(0)), Double.parseDouble(formData.get(1)));
      return notification; //notifications
   }
}
