package com.veggie.src.java.database;

import java.util.List;
import com.veggie.src.java.core.Account;

public interface AccountDatabaseManager extends DatabaseManager {
  public void add(Account account);
  public Account getUser(int userId);
  public int getUserType(int userId);
  public List<Account> getMatchingUsers(List<String> fields, List<String> fieldData);

  public void delete(int userId);
  public void edit(int userId, List<String> fields, List<String> fieldData);
  public void suspend(int userId);
  public void addFee(int userId, double feeAmount);
  public double payFee(int userId, double payment);
}
