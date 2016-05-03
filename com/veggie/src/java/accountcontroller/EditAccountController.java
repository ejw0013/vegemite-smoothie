package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Controller;
import com.veggie.src.java.Account;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;

import java.util.List;
import java.util.ArrayList;

public class EditAccountController implements Controller {
   Form editAccountForm;
   Notification notification;

   public EditAccountController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of Account to Edit");
      builder.addField("New Username");
      builder.addField("New Password");
      builder.addField("New Contact Information");
      editAccountForm = builder.getResult();
   }

   public Form clickEditAccountButton() {
      return editAccountForm;
   }

   public Notification submitForm(Form form) {
      editAccountForm = form;
      List<String> formData = editAccountForm.getData();
      //getuser
      return null;
   }
}
