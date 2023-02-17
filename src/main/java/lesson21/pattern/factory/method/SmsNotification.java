package lesson21.pattern.factory.method;

public class SmsNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending a SMS notification");
    }
}
