package com.veggie.src.java.core;

import java.util.List;

public class LibraryTransactions{

  private static List<Transaction> transactions;
  private static LibraryTransactions instance = null;

  protected LibraryTransactions(final List<Transaction> transactions){
    this.transactions = transactions;
  }

  public static LibraryTransactions getInstance(final List<Transaction> transactions){
    if(instance ==   null){
      instance = new LibraryTransactions(transactions);
    }
    return instance;
  }

  public List<Transaction> getTransactions(){
    return transactions;
  }

  public static void addTransaction(Transaction transaction){
    transactions.add(transaction);
  }
}
