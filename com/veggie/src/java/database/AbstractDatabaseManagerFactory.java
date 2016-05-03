package com.veggie.src.java.database;

public abstract class AbstractDatabaseManagerFactory {
    protected static AbstractDatabaseManagerFactory instance = null;

    public static AbstractDatabaseManagerFactory getInstance() {
        return instance;
    }

    public abstract AccountDatabaseManager createAccountDatabaseManager();
    public abstract ItemDatabaseManager createItemDatabaseManager();
    public abstract LimitsDatabaseManager createLimitsDatabaseManager();
    public abstract TitleDatabaseManager createTitleDatabaseManager();
    public abstract TransactionDatabaseManager createTransactionDatabaseManager();
}
