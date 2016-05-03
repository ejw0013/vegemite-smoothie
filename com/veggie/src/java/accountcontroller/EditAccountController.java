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

public class EditAccountController implements Controller {
   private Form editAccountForm;
   private Notification notification;
   private AccountDatabaseManager manager;

   public EditAccountController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of Account to Edit");
      builder.addField("username");
      builder.addField("password");
      builder.addField("contactInformation");
      editAccountForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }

   public Form clickEditAccountButton() {
      return editAccountForm;
   }

   public Notification submitForm(Form form) {
      editAccountForm = form;
      //List<String> formData = editAccountForm.getData();
      //getuser
      //LookUpUserController lookUp = new LookUpUserController();
      //Account user = lookUp.lookUpUser(Integer.parseInt(formData.get(0)));
      //edit the user
      manager.edit(Integer.parseInt(editAccountForm.getData().get(0)), editAccountForm.getFieldNames(), editAccountForm.getData()); //need to update
      return null;
   }
}
