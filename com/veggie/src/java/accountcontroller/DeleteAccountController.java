package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Controller;
import com.veggie.src.java.Account;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;

import java.util.List;
import java.util.ArrayList;

public class DeleteAccountController implements Controller {
   private Form deleteAccountForm;
   private Notification notification;
   
   public DeleteAccountController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID");
      deleteAccountForm = builder.getResult();
   }

   public Form ClickDeleteAccountButton() {
      return deleteAccountForm;
   }

   public Notification submitForm(Form form) {
      deleteAccountForm = form;
      List<String> formData = deleteAccountForm.getData();
      //find user from ID
      Account user;
      int idNum;
      return null;
   }
}
