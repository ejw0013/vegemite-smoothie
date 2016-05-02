package com.veggie.src.java.database.prototype;

import java.util.List;
import java.util.ArrayList;

import com.veggie.src.java.Transaction;
import com.veggie.src.java.ReservationTransaction;
import com.veggie.src.java.Account;
import com.veggie.src.java.database.TransactionDatabaseManager;


public class PrototypeTransactionDatabaseManager extends PrototypeDatabaseManager implements TransactionDatabaseManager {

    private PrototypeDB db;

    public PrototypeTransactionDatabaseManager(PrototypeDB db) {
      this.db = db;
    }

    public void addReservation(int titleId, int accountId) {

    }

    public boolean checkReserved(int itemId) {
        return false;
    }

    public int getNumberReservations(int userId) {
        return 0;
    }

    public void finalizeTransaction(int itemId) {

    }

    public Account getTransactionUser(int itemId) {
        return null;
    }

    public List<Transaction> getUserTransactions(int userId) {
        return null;
    }

    public List<ReservationTransaction> getUserReservations(int userId) {
        return null;
    }
}
