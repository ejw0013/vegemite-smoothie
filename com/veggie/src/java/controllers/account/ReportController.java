package com.veggie.src.java.controllers.account;

import com.veggie.src.java.core.Account;
import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.AccountDatabaseManager;

import java.util.List;

public class ReportController implements Controller {
   private Notification notification;
   private Form reportForm;
   private AccountDatabaseManager manager;

   public ReportController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      builder.addField("Library ID of User for Report");
      reportForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }

   public Form activate() {
      return reportForm;
   }

   public Notification submitForm(Form form) {
      reportForm = form;
      List<String> formData = reportForm.getData();
      Account user = manager.getUser(Integer.parseInt(formData.get(0)));
      String report = "Account Report for: " + user.getusername() + "\n";
      String accountType = user.getType();
      report += "Account Type: " + accountType + "\n";
      if (user.isActive() == true) report += "Account Status: Active\n";
      else report += "Account Status: Suspended\n";
      report += "Contact Information: " + user.getContactInformation() + "\n";
      report += "Library ID Number: " + user.getId() + "\n";
      //if (accountType == "AssistantAccount" || accountType = "LibrarianAccount")
         //report += "Employee ID Number: " + user.getEmployeeID() + "\n";
      //if (accountType == "FacultyAccount") report += "Faculty ID Number: " + user.getFacultyID() + "\n";
      
      return notification;
   }
}
