package lesson21.pattern.factory.method;

public class PushNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending a push notification");
    }
}
