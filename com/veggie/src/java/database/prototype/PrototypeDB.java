package com.veggie.src.java.database.prototype;

import java.util.Map;
import java.util.HashMap;

import com.veggie.src.java.MediaTitle;
import com.veggie.src.java.MediaItem;
import com.veggie.src.java.Transaction;
import com.veggie.src.java.Account;

public class PrototypeDB {

  private Map<String, MediaTitle> titleTable;
  private Map<Integer, MediaItem> itemTable;
  private Map<Integer, Transaction> transactionTable;
  private Map<Integer, Account> accountTable;

  private int accountId;
  private int transactionId;

  public PrototypeDB() {
    accountId = 0;
    transactionId = 0;
    titleTable = new HashMap<>();
    itemTable = new HashMap<>();
    transactionTable = new HashMap<>();
    accountTable = new HashMap<>();
  }

  public Map<String, MediaTitle> getTitleTable() {
    return titleTable;
  }

  public Map<Integer, MediaItem> getItemTable() {
    return itemTable;
  }

  public Map<Integer, Transaction> getTransactionTable() {
      return transactionTable;
  }

  public Map<Integer, Account> getAccountTable() {
      return accountTable;
  }

  public int getAccountId() {
      return accountId;
  }

  public void setAccountId(int accountId) {
      this.accountId = accountId;
  }

  public int getTransactionId() {
      return transactionId;
  }

  public void setTransactionId(int transactionId) {
      this.transactionId = transactionId;
  }

}
