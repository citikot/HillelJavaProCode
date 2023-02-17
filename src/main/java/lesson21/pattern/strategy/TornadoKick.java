package lesson21.pattern.strategy;

public class TornadoKick implements KickBehavior {
    public void kick() {
        System.out.println("Tornado Kick");
    }
}