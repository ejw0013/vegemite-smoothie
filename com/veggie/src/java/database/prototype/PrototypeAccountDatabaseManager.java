package com.veggie.src.java.database.prototype;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import com.veggie.src.java.Account;
import com.veggie.src.java.AssistantAccount;
import com.veggie.src.java.LibrarianAccount;
import com.veggie.src.java.FacultyAccount;
import com.veggie.src.java.GraduateStudentAccount;
import com.veggie.src.java.UndergraduateStudentAccount;
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

}
