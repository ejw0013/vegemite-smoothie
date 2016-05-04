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

import java.io.*;

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

   public Notification getNotification(Form form) {
      searchUserForm = form;
      List<String> formData = searchUserForm.getData();
      ArrayList<String> fields = new ArrayList<String>(1);
      fields.add(0, "username");
      List<Account> matchingUsers = manager.getMatchingUsers(fields, formData);
      return notification; //notification
   }
}
