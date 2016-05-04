package com.veggie.src.java.controllers.account;

import com.veggie.src.java.core.Account;
import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.AccountDatabaseManager;
import com.veggie.src.java.notification.AbstractNotificationFactory;

import java.util.List;

public class LookUpUserController implements Controller {
   private Form lookUpForm;
   private Notification notification;
   private AccountDatabaseManager manager;

   public LookUpUserController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of User to Look Up");
      lookUpForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }

   public Form activate() {
      return lookUpForm;
   }

   public Notification submitForm(Form form) {
      lookUpForm = form;
      List<String> formData = lookUpForm.getData();
      Account user = manager.getUser(Integer.parseInt(formData.get(0)));
      String report = "User " + user.getusername() + " found!\n";
      notification = AbstractNotificationFactory.getInstance().createSuccessNotification(user.toString()); //NO TOSTRING YET
      return notification;
   }
   
   public void respondToNotification(Notification notification) {
   
   }
}
