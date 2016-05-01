import java.util.Map;
import java.util.HashMap;

public class MediaTitle {

  private Map<String, String> data;

  public MediaTitle() {
    data = new HashMap<>();
  }

  public boolean containsField(String field) {
    return data.containsKey(field);
  }

  public String getData(String field) {
    if (containsField(field)) {
      return data.get(field);
    } else {
      throw new IllegalArgumentException("Field does not exist!");
    }
  }
}
