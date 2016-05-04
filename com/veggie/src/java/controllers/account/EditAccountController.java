package com.veggie.src.java.controllers.account;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.AccountDatabaseManager;
import com.veggie.src.java.notification.AbstractNotificationFactory;

import java.util.List;
import java.util.ArrayList;

public class EditAccountController implements Controller {
   private Form editAccountForm;
   private Notification notification;
   private AccountDatabaseManager manager;

   public EditAccountController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of Account to Edit");
      builder.addField("New Username");
      builder.addField("New Password");
      builder.addField("New Contact Information");
      editAccountForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }

   public Form activate() {
      return editAccountForm;
   }

   public Notification submitForm(Form form) {
      editAccountForm = form;
      List<String> formData = editAccountForm.getData();
      //edit the user
      ArrayList<String> fields = new ArrayList<String>(3);
      fields.set(0, "username");
      fields.set(1, "password");
      fields.set(2, "contactInformation");
      ArrayList<String> fieldData = new ArrayList<String>(3);
      fields.set(0, formData.get(1));
      fields.set(1, formData.get(2));
      fields.set(2, formData.get(3));
      manager.edit(Integer.parseInt(editAccountForm.getData().get(0)), fields, formData);
      notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Account edited!");
      return notification;
   }
   
   public void respondToNotification(Notification notification) {
   
   }
}
