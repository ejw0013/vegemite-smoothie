public abstract class AbstractErrorNotification {
  private boolean recieved;

  public final boolean ok() {
    return false;
  }

  public final boolean recieved() {
    return recieved;
  }

  public final void submit() {
    recieved = true;
  }
}
