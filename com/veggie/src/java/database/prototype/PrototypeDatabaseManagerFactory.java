package com.veggie.src.java.database.prototype;

import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.AccountDatabaseManager;
import com.veggie.src.java.database.ItemDatabaseManager;
import com.veggie.src.java.database.LimitsDatabaseManager;
import com.veggie.src.java.database.TitleDatabaseManager;
import com.veggie.src.java.database.TransactionDatabaseManager;

public class PrototypeDatabaseManagerFactory extends AbstractDatabaseManagerFactory {
    protected static AbstractDatabaseManagerFactory instance = null;

    private PrototypeDB db;

    public PrototypeDatabaseManagerFactory(PrototypeDB db) {
        this.db = db;
    }

    public static AbstractDatabaseManagerFactory getInstance() {
        if (instance == null) {
            instance = new PrototypeDatabaseManagerFactory(new PrototypeDB());
        }
        return instance;
    }

    public AccountDatabaseManager createAccountDatabaseManager() {
        return new PrototypeAccountDatabaseManager(db);
    }

    public ItemDatabaseManager createItemDatabaseManager() {
        return new PrototypeItemDatabaseManager(db);
    }

    public LimitsDatabaseManager createLimitsDatabaseManager() {
        return new PrototypeLimitsDatabaseManager(db);
    }

    public TitleDatabaseManager createTitleDatabaseManager() {
        return new PrototypeTitleDatabaseManager(db);
    }

    public TransactionDatabaseManager createTransactionDatabaseManager() {
        return new PrototypeTransactionDatabaseManager(db);
    }
}
