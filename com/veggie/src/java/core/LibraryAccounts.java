package com.veggie.src.java.core;

import com.veggie.src.java.core.account.EmployeeAccount;
import com.veggie.src.java.core.account.PatronAccount;

import java.util.List;

public class LibraryAccounts{

  private static LibraryAccounts instance = null;
  private List<PatronAccount> patrons;
  private List<EmployeeAccount> employees;

  protected LibraryAccounts(final List<PatronAccount> patrons, final List<EmployeeAccount> employees){
    this.patrons = patrons;
    this.employees = employees;
  }
  public static LibraryAccounts getInstace(final List<PatronAccount> patrons, final List<EmployeeAccount> employees){
    if(instance == null){
      instance = new LibraryAccounts(patrons, employees);
    }
    return instance;
  }
  public List<PatronAccount> getPatrons(){
    return patrons;
  }
  public List<EmployeeAccount> getEmployees(){
    return employees;
  }
  public void addPatron(PatronAccount patron){
    patrons.add(patron);
  }
  public void addEmployee(EmployeeAccount employee){
    employees.add(employee);
  }
}
