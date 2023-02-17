package lesson21.pattern.factory.method;

public class MainFactoryMethod {
    
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification(NotificationChannel.SMS);
        notification.notifyUser();
    }

}
