import java.util.Set;
import java.util.List;

public interface ItemDatabaseManager extends DatabaseManager {
  public void addItem(MediaItem item);
  public MediaItem getItem(int itemId);
  public boolean isReservable(int itemId);
  public void markAvailable(int itemId);
  public void markReserved(int itemId);
  public void markUnavailable(int itemId);
  public Set<MediaItem> getMatchingItems(List<String> fields, List<String> fieldData);
}
