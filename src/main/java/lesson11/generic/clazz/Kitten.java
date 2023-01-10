package lesson11.generic.clazz;

/**
 * @author spasko
 */
public class Kitten extends Cat {
    @Override
    public String name() {
        return "Kitten(demo-variant of " + super.name() + ")";
    }

    public void playGames() {
        System.out.println("Now playing games");
    }
}
