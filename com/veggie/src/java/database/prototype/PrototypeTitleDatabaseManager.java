package com.veggie.src.java.database.prototype;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import com.veggie.src.java.core.media.MediaTitle;
import com.veggie.src.java.database.TitleDatabaseManager;

public class PrototypeTitleDatabaseManager extends PrototypeDatabaseManager implements TitleDatabaseManager {
  private PrototypeDB db;

  public PrototypeTitleDatabaseManager(PrototypeDB db) {
    this.db = db;
  }

  public int checkTitle(String ISBN, List<String> fields, List<String> fieldData) {
    if (!db.getTitleTable().containsKey(ISBN)) {
        return MediaTitle.NEW_TITLE;
    } else {
        MediaTitle title = db.getTitleTable().get(ISBN);
        for (int i = 0; i < fields.size(); i++) {
            String fieldName = fields.get(i);
            String fieldEntry = fieldData.get(i);
            if (fieldName.length() > 0 && title.containsField(fieldName)) {
                if (title.getData(fieldName).equals(fieldEntry)) {
                    return MediaTitle.INVALID_TITLE;
                }
            }
        }
    }
    return MediaTitle.EXISTING_TITLE;
  }

  public void addTitle(String ISBN, MediaTitle title) {
    db.getTitleTable().put(ISBN, title);
  }

  public Set<MediaTitle> getMatches(List<String> fields, List<String> fieldData) {
    Set<MediaTitle> out = null;

    for (int fieldIdx = 0; fieldIdx < fields.size(); fieldIdx++) {
      String field = fields.get(fieldIdx);
      String entry = fieldData.get(fieldIdx);
      Set<MediaTitle> matches = new HashSet<>();

      if (entry.length() == 0) continue;

      for (String ISBN : db.getTitleTable().keySet()) {
        MediaTitle testTitle = db.getTitleTable().get(ISBN);
        if (testTitle.containsField(field) && testTitle.getData(field).equals(entry)) {
          matches.add(testTitle);
        }
      }

      if (out == null) {
          out = new HashSet<>(matches);
      } else {
        out.retainAll(matches);
      }
    }
    return out;
  }

  public boolean titleExists(String ISBN) {
    return db.getTitleTable().containsKey(ISBN);
  }

}
