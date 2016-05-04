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

   public Notification getNotification(Form form) {
      addFeeForm = form;
      List<String> formData = form.getData();
      manager.addFee(Integer.parseInt(formData.get(0)), Double.parseDouble(formData.get(1)));
      return notification; //notification
   }
}
