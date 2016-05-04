package com.veggie.src.java.controllers.account;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.entities.accounts.employees.AssistantAccount;
import com.veggie.src.java.entities.accounts.employees.LibrarianAccount;
import com.veggie.src.java.entities.accounts.patrons.GraduateStudentAccount;
import com.veggie.src.java.entities.accounts.patrons.FacultyAccount;
import com.veggie.src.java.entities.accounts.patrons.UndergraduateStudentAccount;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.AccountDatabaseManager;

import java.util.List;

public class AddAccountController implements Controller {

   private Form addAccountForm;
   private Notification notification;
   private AccountDatabaseManager manager;

   public AddAccountController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      //fields for all account types
      builder.addField("Account Type");
      builder.addField("Username");
      builder.addField("Password");
      builder.addField("Contact Information");
      //fields for employee employees
      builder.addField("Employee ID");
      //fields for patron employees
      builder.addField("Student ID");
      builder.addField("Faculty ID");
      addAccountForm = builder.getResult();
      manager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
   }

   public Form activate() {
      return addAccountForm;
   }
   //fields: accounttype, username, password, contactinfo, employeeid, studentid, facultyid
   public Notification submitForm(Form form) { //NOTIFICATION????
      addAccountForm = form;
      List<String> formData = addAccountForm.getData();
      String accountType = formData.get(0);
      if (accountType == "AssistantAccount") {
         AssistantAccount newUser = new AssistantAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(4)), formData.get(2));
         manager.add(newUser);
      }
      else if (accountType == "LibrarianAccount") {
         LibrarianAccount newUser = new LibrarianAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(4)), formData.get(2));
         manager.add(newUser);
      }
      else if (accountType == "GraduateStudentAccount") {
         GraduateStudentAccount newUser = new GraduateStudentAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(5)), formData.get(2));
         manager.add(newUser);
      }
      else if (accountType == "FacultyAccount") {
         FacultyAccount newUser = new FacultyAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(6)), formData.get(2));
         manager.add(newUser);
      }
      else if (accountType == "UndergraduateStudentAccount") {
         UndergraduateStudentAccount newUser = new UndergraduateStudentAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(5)), formData.get(2));
         manager.add(newUser);
      }
      else {
         System.out.println("Error: invalid account type");
      }
      return notification;   //???????
   }

}
