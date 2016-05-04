package com.veggie.src.java.database.prototype;

import java.util.Set;
import java.util.List;
import com.veggie.src.java.core.media.MediaItem;
import com.veggie.src.java.database.ItemDatabaseManager;

public class PrototypeItemDatabaseManager extends PrototypeDatabaseManager implements ItemDatabaseManager {

    private PrototypeDB db;

    public PrototypeItemDatabaseManager(PrototypeDB db) {
      this.db = db;
    }

    public void addItem(MediaItem item) {
        int id = db.getItemId() + 1;
        db.setItemId(id);
        item.setId(id);
        db.getItemTable().put(id, item);
        System.out.println("LISTING!");
        for (Integer i : db.getItemTable().keySet()) {
            System.out.println(id + ": " + db.getItemTable().get(i));
        }
    }

    public void removeItem(int itemId){
        db.getItemTable().remove(itemId);
    }
    public MediaItem getItem(int itemId) {
        return db.getItemTable().get(itemId);
    }

    public boolean isReservable(int itemId) {
        return true;
    }

    public void markAvailable(int itemId) {
        db.getItemTable().get(itemId).setStatus(MediaItem.AVAILABLE);
    }

    public void markReserved(int itemId) {
        db.getItemTable().get(itemId).setStatus(MediaItem.RESERVED);
    }

    public void markUnavailable(int itemId) {
        db.getItemTable().get(itemId).setStatus(MediaItem.UNAVAILABLE);
    }

    public Set<MediaItem> getMatchingItems(List<String> fields, List<String> fieldData) {
        return null;
    }
}
