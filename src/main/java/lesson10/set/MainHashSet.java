package lesson10.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainHashSet {
    public static void main(String[] args) {
        oneHashSetOperations();

        twoCollectionsOperations();

        mutableSurprises();
    }

    private static void oneHashSetOperations() {
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(2);

        System.out.println("1: " + hashSet);

        hashSet.add(1);
        System.out.println("2: " + hashSet);
        System.out.println("3: " + hashSet.add(4));
        System.out.println("4: " + hashSet.add(4));

        hashSet.remove(2);
        System.out.println("5: " + hashSet);

        System.out.println("6: " + hashSet.contains(4));
        System.out.println("7: " + hashSet.contains(11));

        System.out.println("8: " + hashSet.size());

        hashSet.clear();
        System.out.println("9: " + hashSet.size());

        System.out.println("10: " + hashSet.isEmpty());
    }

    private static void twoCollectionsOperations() {
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(2);

        HashSet<Integer> hashSet2 = new HashSet<>();

        hashSet2.add(1);
        hashSet2.add(3);

        System.out.println("11: " + hashSet.containsAll(hashSet2));

        hashSet.retainAll(hashSet2);
        System.out.println("12: " + hashSet);

        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(2);
        hashSet.removeAll(hashSet2);
        System.out.println("13: " + hashSet);

        hashSet2.add(4);
        hashSet.addAll(hashSet2);
        System.out.println("14: " + hashSet);

        System.out.println("15: " + new HashSet<>(List.of(4, 5, 5, 7, 7)));
    }

    private static void mutableSurprises() {
        Set<Animal> animals = new HashSet<>();

        animals.add(new Animal("Cat", 2));
        System.out.println("16: " + animals);

        Animal animal2 = new Animal("Cat", 2);
        animals.add(animal2);
        System.out.println("17: " + animals);

        animals.clear();
        Animal animal1 = new Animal("Dog", 3);

        animals.add(animal1);
        animals.add(animal2);
        System.out.println("18: " + animals);

        animal1.setName("Cat");
        animal1.setOld(2);
        System.out.println("19: " + animals);
    }
}
