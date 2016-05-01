import java.util.List;
import java.util.ArrayList;

public class TomcatFormBuilder implements AbstractFormBuilder {
  private List<String> formFields;
  private List<String> defaultData;

  protected TomcatFormBuilder() {
    formFields = new ArrayList<>();
    defaultData = new ArrayList<>();
  }

  public void addField(String fieldName) {
    formFields.add(fieldName);
    defaultData.add("");
  }

  public Form getResult() {
    return new TomcatForm(formFields, defaultData);
  }
}
