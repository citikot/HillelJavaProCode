package lesson21.pattern.strategy;

public class LightningKick implements KickBehavior {
    public void kick() {
        System.out.println("Lightning Kick");
    }
}