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

public class DeleteAccountController implements Controller {
   private Form deleteAccountForm;
   private Notification notification;
   private AccountDatabaseManager manager;

   public DeleteAccountController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of Account to Delete");
      deleteAccountForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }

   public Form activate() {
      return deleteAccountForm;
   }

   public Notification submitForm(Form form) {
      deleteAccountForm = form;
      List<String> formData = deleteAccountForm.getData();
      //delete the user
      manager.delete(Integer.parseInt(formData.get(0)));
      notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Account deleted!");
      return notification;
   }
   
   public void respondToNotification(Notification notification) {
   
   }
}
