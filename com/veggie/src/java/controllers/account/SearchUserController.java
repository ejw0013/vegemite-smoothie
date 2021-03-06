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
import java.util.ArrayList;

public class SearchUserController implements Controller {
   private Notification notification;
   private Form searchUserForm;
   private AccountDatabaseManager manager;

   public SearchUserController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Username of User to Find");
      searchUserForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }

   public Form activate () {
      return searchUserForm;
   }

   public Notification submitForm(Form form) {
       try {
      searchUserForm = form;
      List<String> formData = searchUserForm.getData();
      ArrayList<String> fields = new ArrayList<String>(1);
      fields.add(0, "username");
      List<Account> matchingUsers = manager.getMatchingUsers(fields, formData);
      String report = "Matching User(s):\n";
      int size = matchingUsers.size();
      for(int i = 0; i < size; i++) {
         Account user = matchingUsers.get(i);
         report += user.toString() + "\n";
      }
      return AbstractNotificationFactory.getInstance().createSuccessNotification(report);
  } catch (Exception e) {
      e.printStackTrace();
  }
  return null;
   }

   public void respondToNotification(Notification notification) {

   }
}
