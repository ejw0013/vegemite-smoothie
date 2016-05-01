package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Controller;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.TomcatFormBuilder;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.notification.TomcatNotificationFactory;

public class AddAccountController implements Controller {

   private Form addAccountForm;
   private Notification notification;
   private TomcatFormBuilder addAcctFormBuilder;
   private TomcatNotificationFactory notifyFactory;

   public AddAccountController(TomcatFormBuilder formBuilder, TomcatNotificationFactory notifFact) {
      addAccountForm = null;
      notification = null;
      addAcctFormBuilder = formBuilder;
      notifyFactory = notifFact;
   }

   private Form create() {
      addAcctFormBuilder.addField("Username");
      addAcctFormBuilder.addField("Password");
      addAcctFormBuilder.addField("ID Number");
      //addAcctFormBuilder.addField("
      return addAccountForm;
   }

   public Form clickAccountButton() {
      addAccountForm = create();
      return addAccountForm;
   }

   public Notification submitForm(Form form) {
      addAccountForm = form;
      return notification;   //???????
   }

}
