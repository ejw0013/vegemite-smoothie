package com.veggie.src.java.database;

import java.util.Set;
import java.util.List;

public class PrototypeItemDatabaseManager extends PrototypeDatabaseManager implements ItemDatabaseManager {

    private PrototypeDB db;

    public PrototypeItemDatabaseManager(PrototypeDB db) {
      this.db = db;
    }

    public void addItem(MediaItem item) {

    }

    public MediaItem getItem(int itemId) {
        return null;
    }

    public boolean isReservable(int itemId) {
        return false;
    }

    public void markAvailable(int itemId) {

    }

    public void markReserved(int itemId) {

    }

    public void markUnavailable(int itemId) {

    }

    public Set<MediaItem> getMatchingItems(List<String> fields, List<String> fieldData) {
        return null;
    }
}
