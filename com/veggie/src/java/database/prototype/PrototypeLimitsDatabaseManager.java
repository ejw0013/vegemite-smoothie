package com.veggie.src.java.database.prototype;

import com.veggie.src.java.database.LimitsDatabaseManager;

public class PrototypeLimitsDatabaseManager extends PrototypeDatabaseManager implements LimitsDatabaseManager {

    private PrototypeDB db;

    public PrototypeLimitsDatabaseManager(PrototypeDB db) {
      this.db = db;
    }

    public int getTypeRenewalLimit(int accountType) {
        return db.getLimitsTable().get(accountType);
    }
}
