package lesson04.interfaces;

/**
 * @author spasko
 */
public class MainAnimalDragon {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        AnimalDragon animalDragon = new AnimalDragon();
        // default from Animal interface
        System.out.println("1: " + animalDragon.eatPeople());

        // from AnimalDragon class
        System.out.println("2: " + animalDragon.createMeat());
        System.out.println("3: " + ((Dragon) animalDragon).createMeat());

        // static from Animal interface
        System.out.println("4: " + Animal.doSomething());

        // static from Dragon interface
        System.out.println("5: " + Dragon.doSomething());

        // value from AnimalDragon class
        System.out.println("6: " + animalDragon.firstInt);

        // value from Animal interface
        System.out.println("7: " + animalDragon.secondInt);

        // value from Animal interface
        // System.out.println("8: " + animalDragon.thirdInt);
    }
}
