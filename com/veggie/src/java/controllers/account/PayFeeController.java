package com.veggie.src.java.controllers.account;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.AccountDatabaseManager;
import com.veggie.src.java.notification.AbstractNotificationFactory;

import java.util.List;

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

   public Form activate() {
      return payFeeForm;
   }

   public Notification submitForm(Form form) {
      payFeeForm = form;
      List<String> formData = payFeeForm.getData();
      double change = manager.payFee(Integer.parseInt(formData.get(0)), Double.parseDouble(formData.get(1)));
      if (change < 0) {
         String text = "Payment proccessed. Change Due: $" + Math.abs(change);
         notification = AbstractNotificationFactory.getInstance().createSuccessNotification(text);
      }
      else
         notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Payment processed. No change due.");
      return notification;
   }
   
   public void respondToNotification(Notification notification) {
   
   }
}
