package com.veggie.src.java.database;

import java.util.List;

import com.veggie.src.java.Transaction;
import com.veggie.src.java.ReservationTransaction;
import com.veggie.src.java.Account;

public interface TransactionDatabaseManager extends DatabaseManager {
  public void addReservation(int itemId, int accountId);
  public boolean checkReserved(int itemId);
  public int getNumberReservations(int userId);
  public void finalizeTransaction(int itemId);
  public Account getTransactionUser(int itemId);
  public List<Transaction> getUserTransactions(int userId);
  public List<ReservationTransaction> getUserReservations(int userId);
}
