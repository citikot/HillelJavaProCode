package lesson08.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author spasko
 */
public class MainArrayList {

    public static void main(String[] args) {

        Animal animal1 = new Animal("Dog", 13);
        Animal animal2 = new Animal("Cat", 2);
        Animal animal3 = new Animal("Dog", 7);
        Animal animal4 = new Animal("Hedgehog", 3);

        List<Animal> listAnimals = new ArrayList<>();
        listAnimals.add(animal1);
        listAnimals.add(animal2);
        listAnimals.add(animal3);
        listAnimals.add(animal4);

        System.out.println("1: " + listAnimals);

        //        for (Animal value : listAnimals) {
        //            if (value.equals(animal1)) {
        //                listAnimals.remove(value);
        //            }
        //        }
        //
        //        listAnimals.removeIf(an -> an.equals(animal1));
        //        System.out.println("2: " + listAnimals);

        Comparator<Animal> animalComparator = new Comparator<Animal>() {
            @Override
            public int compare(Animal animalFirst, Animal animalSecond) {
                int compareName = animalFirst.getName()
                        .compareTo(animalSecond.getName());
                if (compareName == 0) {
                    return Integer.compare(animalFirst.getOld(), animalSecond.getOld());
                } else {
                    return compareName;
                }
            }
        };

        //Collections.sort(listAnimals);
        //listAnimals.sort();

        System.out.println("3: " + listAnimals);
    }
}
