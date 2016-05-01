
public abstract class AbstractSuccessNotification implements Notification {
  private boolean recieved;

  public final boolean ok() {
    return recieved;
  }

  public final boolean recieved() {
    return recieved;
  }

  public final void submit() {
    recieved = true;
  }
}
