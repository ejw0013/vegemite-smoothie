package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Controller;
import com.veggie.src.java.Account;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.AccountDatabaseManager;

import java.util.List;
import java.util.ArrayList;

public class SuspendAccountController implements Controller {
   private Form suspendAccountForm;
   private Notification notification;
   private AccountDatabaseManager manager;

   public SuspendAccountController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of Account to Suspend");
      suspendAccountForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }

   public Form clickSuspendAccountButton() {
      return suspendAccountForm;
   }

   public Notification submitForm(Form form) {
      suspendAccountForm = form;
      List<String> formData = suspendAccountForm.getData();
      //suspend the user
      manager.suspend(Integer.parseInt(formData.get(0)));
      return null; //notification
   }
}
