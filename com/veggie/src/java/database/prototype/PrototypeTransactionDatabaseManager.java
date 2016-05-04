package com.veggie.src.java.database.prototype;

import java.util.List;
import java.util.ArrayList;

import com.veggie.src.java.core.Transaction;
import com.veggie.src.java.core.transaction.ReservationTransaction;
import com.veggie.src.java.core.transaction.RentalTransaction;
import com.veggie.src.java.core.transaction.RequestTransaction;
import com.veggie.src.java.core.Account;
import com.veggie.src.java.database.TransactionDatabaseManager;
import com.veggie.src.java.core.media.MediaItem;


public class PrototypeTransactionDatabaseManager extends PrototypeDatabaseManager implements TransactionDatabaseManager {

    private PrototypeDB db;

    public PrototypeTransactionDatabaseManager(PrototypeDB db) {
      this.db = db;
    }

    public void addTransaction(Transaction transaction) {
        int transactionId = db.getTransactionId() + 1;
        transaction.setId(transactionId);
        db.getTransactionTable().put(transactionId, transaction);
        db.setTransactionId(transactionId);
    }

    public boolean checkReserved(int itemId) {
        return db.getItemTable().get(itemId).getStatus() == MediaItem.RESERVED;
    }

    public int getNumberReservations(int userId) {
        int count = 0;
        for (Integer transactionId : db.getTransactionTable().keySet()) {
            Transaction transaction = db.getTransactionTable().get(transactionId);
            if (transaction instanceof ReservationTransaction) {
                if (getTransactionUser(transactionId).getId() == userId) {
                    count += transaction.getStatus() == Transaction.ACTIVE ? 1 : 0;
                }
            }
        }
        return count;
    }

    public void finalizeTransaction(int transactionId) {
        Transaction transaction = db.getTransactionTable().get(transactionId);
        transaction.resolve();
    }

    public Account getTransactionUser(int transactionId) {
        return db.getTransactionTable().get(transactionId).getPatronAccount();
    }

    public Account getCurrentRenter(int itemId) {
        Account out = null;
        for (Integer transactionId : db.getTransactionTable().keySet()) {
            Transaction transaction = db.getTransactionTable().get(transactionId);
            if (transaction instanceof RentalTransaction && transaction.getStatus() == Transaction.ACTIVE) {
                RentalTransaction rental = (RentalTransaction) transaction;
                if (rental.getItem().getId() == itemId) {
                    out = rental.getPatronAccount();
                }
            }
        }
        return out;
    }

    public List<Transaction> getUserTransactions(int userId) {
        List<Transaction> out = new ArrayList<>();

        for (Integer transactionId : db.getTransactionTable().keySet()) {
            Transaction transaction = db.getTransactionTable().get(transactionId);
            if (transaction.getPatronAccount().getId() == userId) {
                out.add(transaction);
            }
        }

        return out;
    }

    public List<ReservationTransaction> getUserReservations(int userId) {
        List<ReservationTransaction> out = new ArrayList<>();

        for (Integer transactionId : db.getTransactionTable().keySet()) {
            Transaction transaction = db.getTransactionTable().get(transactionId);
            if (transaction.getPatronAccount().getId() == userId) {
                if (transaction instanceof ReservationTransaction)
                out.add((ReservationTransaction)transaction);
            }
        }
        return out;
    }

    public void finalizeReservation(int userId, int itemId) {
        for(Integer transactionId : db.getTransactionTable().keySet()) {
            Transaction transaction = db.getTransactionTable().get(transactionId);
            if(transaction.getPatronAccount().getId() == userId && transaction.getId() == itemId){
                if(transaction instanceof ReservationTransaction)
                    transaction.resolve();
            }
        }
    }

    public List<Transaction> getRequests() {
        List<Transaction> output = new ArrayList<>();
        for(Integer transactionId : db.getTransactionTable().keySet()){
            Transaction transaction = db.getTransactionTable().get(transactionId);
            if(transaction.getStatus() == Transaction.ACTIVE){
               if(transaction instanceof RequestTransaction) 
                output.add(transaction);
            }
        }
        return output;
    }

    public void resolveRequest(int transactionId) {
        db.getTransactionTable().remove(transactionId);
    }

    public boolean requestExists(int transactionId){
        if(db.getTransactionTable().get(transactionId) != null){
            Transaction transaction = db.getTransactionTable().get(transactionId);
            if(transaction instanceof RequestTransaction){
                if( transaction.getStatus() == Transaction.ACTIVE){
                    return true;
                }
            }
        }
        return false;
    }
}
