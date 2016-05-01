public interface AbstractNotificationFactory {
  public AbstractErrorNotification createErrorNotification(String message);
  public AbstractSuccessNotification createSuccessNotification(String message);
  public AbstractConfirmNotification createConfirmNotification(String message);
}
