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

public class AddFeeController implements Controller {
   private Notification notification;
   private Form addFeeForm;
   private AccountDatabaseManager manager;

   public AddFeeController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of User");
      builder.addField("Fee Amount");
      addFeeForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }

   public Form activate() {
      return addFeeForm;
   }

   public Notification submitForm(Form form) {
      addFeeForm = form;
      List<String> formData = form.getData();
      manager.addFee(Integer.parseInt(formData.get(0)), Double.parseDouble(formData.get(1)));
      notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Fee Added!");
      return notification; 
   }
   
   public void respondToNotification(Notification notification) {
   
   }
}
