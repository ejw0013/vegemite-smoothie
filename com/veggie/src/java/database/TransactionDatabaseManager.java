package com.veggie.src.java.database;

import java.util.List;

import com.veggie.src.java.core.Transaction;
import com.veggie.src.java.core.transaction.ReservationTransaction;
import com.veggie.src.java.core.Account;

public interface TransactionDatabaseManager extends DatabaseManager {
  public void addTransaction(Transaction transaction);
  public boolean checkReserved(int itemId);
  public int getNumberReservations(int userId);
  public void finalizeTransaction(int itemId);
  public Account getTransactionUser(int itemId);
  public List<Transaction> getUserTransactions(int userId);
  public List<ReservationTransaction> getUserReservations(int userId);
  public void finalizeReservation(int itemId, int userId);
}
