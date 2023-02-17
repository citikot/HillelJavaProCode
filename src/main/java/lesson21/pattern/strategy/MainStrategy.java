package lesson21.pattern.strategy;

public class MainStrategy {
    public static void main(String args[]) {
        // let us make some behaviors first
        JumpBehavior shortJump = new ShortJump();
        JumpBehavior longJump = new LongJump();
        KickBehavior tornadoKick = new TornadoKick();

        // Make a fighter with desired behaviors
        Fighter ken = new Ken(tornadoKick, shortJump);
        ken.display();

        // Test behaviors
        ken.punch();
        ken.kick();
        ken.jump();
        
        System.out.println();

        // Change behavior dynamically (algorithms are
        // interchangeable)
        ken.setJumpBehavior(longJump);
        ken.jump();
    }
}
