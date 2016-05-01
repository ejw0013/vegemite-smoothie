import java.util.List;

public class TomcatForm implements Form {
  private List<String> data;
  private List<String> fieldNames;

  protected TomcatForm(List<String> fieldNames, List<String> defaultData) {
    this.fieldNames = fieldNames;
    this.data = defaultData;
  }

  public String render() {
    return data.toString();
  }

  public List<String> getFieldNames() {
    return fieldNames;
  }

  public List<String> getData() {
    return data;
  }
}
