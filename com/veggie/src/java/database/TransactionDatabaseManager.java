package com.veggie.src.java.database;

import java.util.List;

public interface TransactionDatabaseManager extends DatabaseManager {
  public void addReservation(int itemId, int accountId);
  public boolean checkReserved(int itemId);
  public int getNumberReservations(int userId);
  public void finalizeTransaction(int itemId);
  public Account getTransactionUser(int itemId);
  public List<Transaction> getUserTransactions(int userId);
  public List<Reservation> getUserReservations(int userId);
}
