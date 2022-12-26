package lesson09.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author spasko
 */
public class MainMap {

    public static void main(String[] args) {

        Animal animal1 = new Animal("Dog", 3);
        Animal animal2 = new Animal("Cat", 2);

        Map<Animal, String> mapAnimals = new HashMap<>();
        mapAnimals.put(animal1, "Bobic");
        mapAnimals.put(animal2, "Murka");
        System.out.println("1: " + mapAnimals);

        animal1.setName("Pig");
        animal1.setOld(12);
        System.out.println("2: " + mapAnimals);
        System.out.println("3: " + mapAnimals.get(new Animal("Cat", 2)));
        System.out.println("4: " + mapAnimals.get(new Animal("Pig", 12)));
        System.out.println("5: " + mapAnimals.get(animal1));

        //It's a "crutch"
        Map<Animal, String> mapAnimalsRestored = new HashMap<>(mapAnimals);
        System.out.println("6: " + mapAnimalsRestored.get(new Animal("Pig", 12)));
        System.out.println("7: " + mapAnimalsRestored.get(animal1));
    }
}
