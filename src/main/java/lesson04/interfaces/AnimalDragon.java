package lesson04.interfaces;

/**
 * @author spasko
 */
public class AnimalDragon implements Animal, Dragon {
    int firstInt = 300;

    @Override
    public String createMeat() {
        return Dragon.super.createMeat() + " OR " + Animal.super.createMeat();
    }

    @Override
    public String name() {
        return "AnimalDragon";
    }

    @Override
    public String say() {
        return "Ar-r-r-r";
    }

}
