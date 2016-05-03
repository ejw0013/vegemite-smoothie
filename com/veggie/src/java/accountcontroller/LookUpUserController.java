package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Account;
import com.veggie.src.java.Controller;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;

public class LookUpUserController implements Controller {
   private Form lookUpForm;
   private Notification notification;
   
   public LookUpUserController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of User to Look Up");
      lookUpForm = builder.getResult();
   }

   public Form clickLookUpUser() {
      return lookUpForm;
   }
   
   public Account lookUpUser(int idNum) {
      return null; //TODO: fill in
   }

   public Notification getNotification() {
      //lookUpForm = 
      return notification;
   }
}
