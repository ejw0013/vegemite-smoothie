import java.util.Set;
import java.util.List;
import java.util.HashSet;

public class PrototypeTitleDatabaseManager extends PrototypeDatabaseManager implements TitleDatabaseManager {
  private PrototypeDB db;

  public PrototypeTitleDatabaseManager(PrototypeDB db) {
    this.db = db;
  }

  public int checkTitle(String ISBN, List<String> fields, List<String> fieldData) {
    return 0;
  }

  public void addTitle(String ISBN, MediaTitle title) {
    db.getTitleTable().put(ISBN, title);
  }

  public Set<MediaTitle> getMatches(List<String> fields, List<String> fieldData) {
    Set<MediaTitle> out = null;

    for (int fieldIdx = 0; fieldIdx < fields.size(); fieldIdx++) {
      String field = fields.get(fieldIdx);
      String entry = fieldData.get(fieldIdx);
      Set<String> matches = new HashSet<>();

      if (entry.size() == 0) continue;

      for (String ISBN : db.getTitleTable().keySet()) {
        MediaTitle testTitle = db.getTitleTable().get(ISBN);
        if (testTitle.containsField(field) && testTitle.getData(field).equals(entry)) {
          matches.add(MediaTitle);
        }
      }
    }

  }

  public boolean titleExists(String ISBN) {
    return db.getTitleTable.containsKey(ISBN);
  }

}
