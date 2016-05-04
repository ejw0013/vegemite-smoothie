package com.veggie.src.java.database;

import java.util.List;

import com.veggie.src.java.entities.Transaction;
import com.veggie.src.java.entities.transactions.ReservationTransaction;
import com.veggie.src.java.entities.Account;

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
