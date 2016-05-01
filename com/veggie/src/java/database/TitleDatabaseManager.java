package com.veggie.src.java.database;

import java.util.Set;
import java.util.List;

public interface TitleDatabaseManager extends DatabaseManager {
  int checkTitle(String ISBN, List<String> fields, List<String> fieldData);
  void addTitle(String ISBN, MediaTitle title);
  Set<MediaTitle> getMatches(List<String> fields, List<String> fieldData);
  boolean titleExists(String ISBN);
}
