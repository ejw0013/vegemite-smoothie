package com.veggie.src.java.database.prototype;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import com.veggie.src.java.core.Account;
import com.veggie.src.java.core.account.employee.AssistantAccount;
import com.veggie.src.java.core.account.employee.LibrarianAccount;
import com.veggie.src.java.core.account.patron.FacultyAccount;
import com.veggie.src.java.core.account.patron.GraduateStudentAccount;
import com.veggie.src.java.core.account.patron.UndergraduateStudentAccount;
import com.veggie.src.java.database.AccountDatabaseManager;

public class PrototypeAccountDatabaseManager extends PrototypeDatabaseManager implements AccountDatabaseManager {

    private PrototypeDB db;

    public PrototypeAccountDatabaseManager(PrototypeDB db) {
      this.db = db;
    }

    public void add(Account account) {
        int accountId = db.getAccountId() + 1;
        account.setId(accountId);
        db.getAccountTable().put(accountId, account);
        db.setAccountId(accountId);
    }

    public Account getUser(int userId) {
        return db.getAccountTable().get(userId);
    }

    public int getUserType(int userId) {
        Account account = getUser(userId);
        if (account instanceof AssistantAccount) {
            return Account.ASSISTANT;
        } else if (account instanceof LibrarianAccount) {
            return Account.LIBRARIAN;
        } else if (account instanceof FacultyAccount) {
            return Account.FACULTY;
        } else if (account instanceof GraduateStudentAccount) {
            return Account.GRADUATE_STUDENT;
        } else if (account instanceof UndergraduateStudentAccount) {
            return Account.UNDERGRADUATE_STUDENT;
        } else {
            return Account.UNKNOWN;
        }
    }

    public List<Account> getMatchingUsers(List<String> fields, List<String> fieldData) {
        Set<Account> output = new HashSet<>();

        for (int i = 0; i < fields.size(); i++) {

            String fieldName = fields.get(i);
            String fieldEntry = fieldData.get(i);

            if (fieldEntry.length() > 0) {
                for (Integer accountId : db.getAccountTable().keySet()) {
                    Account account = db.getAccountTable().get(accountId);

                    if (account.fieldExists(fieldName) && account.getData(fieldName).equals(fieldEntry)) {
                        output.add(account);
                    }
                }
            }
        }

        return new ArrayList<Account>(output);
    }

    public void delete(int userId) {
        db.getAccountTable().remove(userId);
    }

    public void edit(int userId, List<String> fields, List<String> fieldData) {
        Account user = db.getAccountTable().get(userId);
        for (int i = 0; i < fields.size(); i++) {
            String fieldName = fields.get(i);
            String fieldEntry = fieldData.get(i);
            if (user.fieldExists(fieldName) && fieldEntry.length() > 0) {
                user.setData(fieldName, fieldEntry);
            }
        }
    }

    public void suspend(int userId) {
        Account user = db.getAccountTable().get(userId);
        user.suspend();
    }

    public void addFee(int userId, double feeAmount) {
        Account user = db.getAccountTable().get(userId);
        user.addFees(feeAmount);
    }

    public double payFee(int userId, double payment) {
        Account user = db.getAccountTable().get(userId);
        double prevBalance = user.getFees();
        double paidToBalance = Math.min(prevBalance, payment);
        double change = prevBalance - payment;
        user.payFees(paidToBalance);
        return change;
    }

    public Account matchUsername(String username) {
        for (Integer id : db.getAccountTable().keySet()) {
            Account a = db.getAccountTable().get(id);
            if (a.getusername().equals(username)) {
                return a;
            }
        }
        return null;
    }

}
