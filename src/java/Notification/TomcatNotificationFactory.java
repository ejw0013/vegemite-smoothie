public class TomcatNotificationFactory implements AbstractNotificationFactory {

  public TomcatErrorNotification createErrorNotification(String message) {
    return new TomcatErrorNotification(message);
  }

  public TomcatConfirmNotification createConfirmNotification(String message) {
    return new TomcatConfirmNotification(message);
  }

  public TomcatSuccessNotification createSuccessNotification(String message) {
    return new TomcatSuccessNotification(message);
  }
}
