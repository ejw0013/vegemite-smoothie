package com.veggie.src.java.database;

import java.util.List;
import com.veggie.src.java.Account;

public interface AccountDatabaseManager extends DatabaseManager {
  public void add(Account account);
  public Account getUser(int userId);
  public int getUserType(int userId);
  public List<Account> getMatchingUsers(List<String> fields, List<String> fieldData);
}
