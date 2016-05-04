package com.veggie.src.java.controllers.account;

import com.veggie.src.java.core.Account;
import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.AccountDatabaseManager;
import com.veggie.src.java.core.account.EmployeeAccount;
import com.veggie.src.java.core.account.patron.FacultyAccount;
import com.veggie.src.java.core.account.patron.GraduateStudentAccount;
import com.veggie.src.java.core.account.patron.UndergraduateStudentAccount;

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
      String report = generateReport(user);
      /*
      String report = "Account Report for: " + user.getusername() + "\n";
      String accountType = user.getType();
      report += "Account Type: " + accountType + "\n";
      if (user.isActive() == true) report += "Account Status: Active\n";
      else report += "Account Status: Suspended\n";
      report += "Contact Information: " + user.getContactInformation() + "\n";
      report += "Library ID Number: " + user.getId() + "\n";
      if (accountType.equals("AssistantAccount") || accountType.equals("LibrarianAccount")) {
         EmployeeAccount employee = (EmployeeAccount) user;
         report += "Employee ID Number: " + employee.getEmployeeId() + "\n";
      }
      if (accountType.equals("FacultyAccount")) {
         FacultyAccount faculty = (FacultyAccount) user;
         report += "Faculty ID Number: " + faculty.getFacultyId() + "\n";
      }
      if (accountType.equals("UndergraduateStudentAccount")) {
         UndergraduateStudentAccount undergrad = (UndergraduateStudentAccount) user;
         report += "Student ID Number: " + undergrad.getStudentId() + "\n";
      }
      if (accountType.equals("GraduateStudentAccount")) {
         UndergraduateStudentAccount grad = (UndergraduateStudentAccount) user;
         report += "Student ID Number: " + grad.getStudentId() + "\n";
      }*/
      return notification;
   }
   
   private String generateReport(Account user) {
      String report = "Account Report for: " + user.getusername() + "\n";
      String accountType = user.getType();
      report += "Account Type: " + accountType + "\n";
      if (user.isActive() == true) report += "Account Status: Active\n";
      else report += "Account Status: Suspended\n";
      report += "Contact Information: " + user.getContactInformation() + "\n";
      report += "Library ID Number: " + user.getId() + "\n";
      if (accountType.equals("AssistantAccount") || accountType.equals("LibrarianAccount")) {
         EmployeeAccount employee = (EmployeeAccount) user;
         report += "Employee ID Number: " + employee.getEmployeeId() + "\n";
      }
      if (accountType.equals("FacultyAccount")) {
         FacultyAccount faculty = (FacultyAccount) user;
         report += "Faculty ID Number: " + faculty.getFacultyId() + "\n";
      }
      if (accountType.equals("UndergraduateStudentAccount")) {
         UndergraduateStudentAccount undergrad = (UndergraduateStudentAccount) user;
         report += "Student ID Number: " + undergrad.getStudentId() + "\n";
      }
      if (accountType.equals("GraduateStudentAccount")) {
         UndergraduateStudentAccount grad = (UndergraduateStudentAccount) user;
         report += "Student ID Number: " + grad.getStudentId() + "\n";
      }
      report += "Current Fee Balance: " + user.getFees() + "\n";
      return report;
   }
}
