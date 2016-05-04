package com.veggie.src.java.database;

import com.veggie.src.java.database.prototype.PrototypeDatabaseManagerFactory;
import com.veggie.src.java.database.prototype.PrototypeDB;

public abstract class AbstractDatabaseManagerFactory {
    protected static AbstractDatabaseManagerFactory instance = null;

    public static AbstractDatabaseManagerFactory getInstance() {
        if (instance == null) {
            instance = new PrototypeDatabaseManagerFactory(new PrototypeDB());
        }
        return instance;
    }

    public abstract AccountDatabaseManager createAccountDatabaseManager();
    public abstract ItemDatabaseManager createItemDatabaseManager();
    public abstract LimitsDatabaseManager createLimitsDatabaseManager();
    public abstract TitleDatabaseManager createTitleDatabaseManager();
    public abstract TransactionDatabaseManager createTransactionDatabaseManager();
}
