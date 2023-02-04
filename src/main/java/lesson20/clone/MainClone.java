package lesson20.clone;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author spasko
 */
@SuppressWarnings("unused")
public class MainClone {
    public static void main(String[] args) {
        List<Animal> animalsList = new ArrayList<>();
        animalsList.add(new Animal("Cat"));
        animalsList.add(new Animal("Dog"));
        System.out.println("1: animalsList:" + animalsList);

        List<Animal> animalsListShallowClone = animalsList.stream()
                .collect(Collectors.toList());
        animalsListShallowClone = new ArrayList<>(animalsList);
        System.out.println("2: animalsListShallowClone:" + animalsListShallowClone);

        animalsList.get(0)
                .setName("Pig");
        System.out.println("3: animalsList:" + animalsList);
        System.out.println("4: animalsListShallowClone:" + animalsListShallowClone);

        System.out.println("------------");

        List<Animal> animalsListDeepClone = new ArrayList<>();
        animalsList.forEach(animal -> {
            try {
                animalsListDeepClone.add((Animal) animal.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("5: animalsList:" + animalsList);
        System.out.println("6: animalsListDeepClone:" + animalsListDeepClone);
        animalsListDeepClone.get(0)
                .setName("Rabbit");
        System.out.println("7: animalsList:" + animalsList);
        System.out.println("8: animalsListDeepClone:" + animalsListDeepClone);
    }
}
