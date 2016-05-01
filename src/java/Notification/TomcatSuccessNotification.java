public class TomcatSuccessNotification extends AbstractSuccessNotification {
  private String message;

  protected TomcatSuccessNotification (String message) {
    this.message = message;
  }

  public String render() {
    return this.message;
  }
}
