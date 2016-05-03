package com.veggie.src.java.accountcontroller;

import com.veggie.src.java.Controller;
import com.veggie.src.java.AssistantAccount;
import com.veggie.src.java.LibrarianAccount;
import com.veggie.src.java.GraduateStudentAccount;
import com.veggie.src.java.FacultyAccount;
import com.veggie.src.java.UndergraduateStudentAccount;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.notification.TomcatNotificationFactory;

import java.util.List;
import java.util.ArrayList;

public class AddAccountController implements Controller {

   private Form addAccountForm;
   private Notification notification;

   public AddAccountController() {
      notification = null;
      AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
      //fields for all account types
      builder.addField("Account Type");
      builder.addField("Username");
      builder.addField("Password");
      builder.addField("Contact Information");
      //fields for employee accounts
      builder.addField("Employee ID");
      //fields for patron accounts
      builder.addField("Student ID");
      builder.addField("Faculty ID");
      addAccountForm = builder.getResult();
   }

   public Form clickAccountButton() {
      return addAccountForm;
   }
   //fields: accounttype, username, password, contactinfo, employeeid, studentid, facultyid
   public Notification submitForm(Form form) {
      addAccountForm = form;
      List<String> formData = addAccountForm.getData();
      String accountType = formData.get(0);
      if (accountType == "AssistantAccount") {
         AssistantAccount newUser = new AssistantAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(4)), formData.get(2));
         //add to account 
      }
      else if (accountType == "LibrarianAccount") {
         LibrarianAccount newUser = new LibrarianAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(4)), formData.get(2));
      }
      else if (accountType == "GraduateStudentAccount") {
         GraduateStudentAccount newUser = new GraduateStudentAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(5)), formData.get(2));
      }
      else if (accountType == "FacultyAccount") {
         FacultyAccount newUser = new FacultyAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(6)), formData.get(2));
      }
      else if (accountType == "UndergraduateStudentAccount") {
         UndergraduateStudentAccount newUser = new UndergraduateStudentAccount(formData.get(1), formData.get(3), 0, Integer.parseInt(formData.get(5)), formData.get(2));
      }
      else {
         System.out.println("Error: invalid account type");
      } 
      return notification;   //???????
   }

}
