import java.util.List;

public interface Form {
  public String render();
  public List<String> getFieldNames();
  public List<String> getData();
}
