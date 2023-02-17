package lesson21.pattern.strategy;

public class ShortJump implements JumpBehavior {
    public void jump() {
        System.out.println("Short Jump");
    }
}