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
      try {
      editAccountForm = form;
      List<String> formData = editAccountForm.getData();
      //edit the user
      ArrayList<String> fields = new ArrayList<String>();
      fields.add("username");
      fields.add("password");
      fields.add("contactInformation");
      ArrayList<String> fieldData = new ArrayList<String>();
      fieldData.add(formData.get(1));
      fieldData.add(formData.get(2));
      fieldData.add(formData.get(3));
      manager.edit(Integer.parseInt(editAccountForm.getData().get(0)), fields, fieldData);
      notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Account edited!");
  } catch (Exception e) {
      e.printStackTrace();
      notification = AbstractNotificationFactory.getInstance().createErrorNotification("An error occurred");
  }
      return notification;
   }

   public void respondToNotification(Notification notification) {

   }
}
