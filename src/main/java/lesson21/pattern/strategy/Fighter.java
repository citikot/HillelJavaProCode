package lesson21.pattern.strategy;

public abstract class Fighter {
    private KickBehavior kickBehavior;
    private JumpBehavior jumpBehavior;

    protected Fighter(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        this.jumpBehavior = jumpBehavior;
        this.kickBehavior = kickBehavior;
    }

    public void punch() {
        System.out.println("Default Punch");
    }

    public void kick() {
        // delegate to kick behavior
        kickBehavior.kick();
    }

    public void jump() {
        // delegate to jump behavior
        jumpBehavior.jump();
    }

    public void roll() {
        System.out.println("Default Roll");
    }

    public void setKickBehavior(KickBehavior kickBehavior) {
        this.kickBehavior = kickBehavior;
    }

    public void setJumpBehavior(JumpBehavior jumpBehavior) {
        this.jumpBehavior = jumpBehavior;
    }

    public abstract void display();
}