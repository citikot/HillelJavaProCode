package lesson21.pattern.factory.method;

public class NotificationFactory {
    public Notification createNotification(NotificationChannel notificationChannel) {
        if (notificationChannel == null) {
            return null;
        }
        return switch (notificationChannel) {
            case SMS -> new SmsNotification();
            case EMAIL -> new EmailNotification();
            case PUSH -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notificationChannel " + notificationChannel);
        };
    }
}
