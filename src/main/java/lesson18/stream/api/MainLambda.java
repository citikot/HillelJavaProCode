package lesson18.stream.api;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lesson18.stream.api.FruitType.APPLE;
import static lesson18.stream.api.FruitType.ORANGE;
import static lesson18.stream.api.FruitType.PEAR;
import static lesson18.stream.api.FruitType.STRAWBERRY;
import static lesson18.stream.api.Vitamin.A;
import static lesson18.stream.api.Vitamin.B;
import static lesson18.stream.api.Vitamin.B1;
import static lesson18.stream.api.Vitamin.B2;
import static lesson18.stream.api.Vitamin.C;
import static lesson18.stream.api.Vitamin.D;
import static lesson18.stream.api.Vitamin.E;
import static lesson18.stream.api.Vitamin.P;

/**
 * @author spasko
 */
public class MainLambda {
    public static void main(String[] args) {
        List<Fruit> fruits = fillFruitsList();
        fruits.forEach(System.out::println);

        intermediateMethods(fruits);
        System.out.println("-----------------------------------------");
        terminatedMethods(fruits);
        System.out.println("-----------------------------------------");
        collectMethods(fruits);
    }

    private static void intermediateMethods(List<Fruit> fruits) {
        System.out.println("\nFind only pears");
        fruits.stream()
                .filter(fr -> PEAR.equals(fr.getFruitType()))
                .forEach(System.out::println);

        System.out.println("\nSkip first 4 elements");
        fruits.stream()
                .skip(4)
                .forEach(System.out::println);

        System.out.println("\nRemove repeat objects");
        fruits.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\nShow type and price");
        fruits.stream()
                .map(fr -> fr.getFruitType() + " has price:" + fr.getPrice())
                .forEach(System.out::println);

        System.out.println("\nShow type only for each");
        fruits.stream()
                .map(Fruit::getFruitType)
                .forEach(System.out::println);

        System.out.println("\nLogging for show type only for each");
        fruits.stream()
                .peek(fr -> System.out.print("For " + fr + " we show "))
                .map(Fruit::getFruitType)
                .forEach(System.out::println);

        System.out.println("\nShow first 4 elements");
        fruits.stream()
                .limit(4)
                .forEach(System.out::println);

        System.out.println("\nShow ordering elements");
        Comparator<Fruit> comparator = (fruit1, fruit2) -> {
            int result = fruit1.getFruitType()
                    .toString()
                    .compareTo(fruit2.getFruitType()
                            .toString());
            if (result != 0) {
                return result;
            } else {
                return fruit1.getPrice() - fruit2.getPrice();
            }
        };
        fruits.stream()
                .sorted(comparator)
                .forEach(System.out::println);

        System.out.println("\nConvert to intStream");
        int[] prices = fruits.stream()
                .mapToInt(Fruit::getPrice)
                .toArray();
        System.out.println(Arrays.toString(prices));

        System.out.println("\nShow vitamins for every fruit");
        fruits.stream()
                .peek(fr -> System.out.println("For " + fr + " we show "))
                .flatMap(fr -> fr.getVitamins()
                        .stream())
                .forEach(System.out::println);

        System.out.println("\nShow all vitamins that present now in fruits");
        fruits.stream()
                .flatMap(fr -> fr.getVitamins()
                        .stream())
                .distinct()
                .forEach(System.out::println);
    }

    private static void terminatedMethods(List<Fruit> fruits) {

        System.out.println("\nFind first in stream");
        System.out.println(fruits.stream()
                .findFirst()
                .get());

        System.out.println("\nFind any element in stream");
        System.out.println(fruits.parallelStream()
                .findAny()
                .get());

        System.out.println("\nCount apples");
        System.out.println(fruits.stream()
                .filter(fr -> PEAR.equals(fr.getFruitType()))
                .count());

        System.out.println("\nHave we fruits that can live more 50 days?");
        System.out.println(fruits.stream()
                .anyMatch(fr -> fr.getDayToLive() > 50));

        System.out.println("\nCannot any fruits live more 100 days?");
        System.out.println(fruits.stream()
                .noneMatch(fr -> fr.getDayToLive() > 100));

        System.out.println("\nCan all fruits live more 30 days?");
        System.out.println(fruits.stream()
                .noneMatch(fr -> fr.getDayToLive() > 30));

        System.out.println("\nMinimum time to live is");
        System.out.println(fruits.stream()
                .map(Fruit::getDayToLive)
                .min(Comparator.naturalOrder())
                .get());

        System.out.println("\nMaximum time to live is");
        System.out.println(fruits.stream()
                .map(Fruit::getDayToLive)
                .max(Comparator.naturalOrder())
                .get());

        System.out.println("\nShow forEach parallel");
        fruits.parallelStream()
                .forEach(System.out::println);

        System.out.println("\nShow forEachOrdered parallel");
        fruits.parallelStream()
                .forEachOrdered(System.out::println);

        System.out.println("\nShow array of deliveryDates");
        LocalDate[] arrayDate = fruits.stream()
                .map(Fruit::getDeliveryDate)
                .toArray(LocalDate[]::new);
        System.out.println(Arrays.toString(arrayDate));

        System.out.println("\nShow border timeToLive(bigger then) and price(less then)");
        Fruit comlexFruit = fruits.stream()
                .reduce((fr1, fr2) -> {
                    Fruit result = new Fruit(null, -1, null, -1, null);
                    result.setPrice(Math.max(fr1.getPrice(), fr2.getPrice()));
                    result.setDayToLive(Math.min(fr1.getDayToLive(), fr2.getDayToLive()));
                    return result;
                })
                .get();
        System.out.println(comlexFruit);
    }

    private static void collectMethods(List<Fruit> fruits) {
        System.out.println("\nList of deliveryDates");
        System.out.println(fruits.stream()
                .map(Fruit::getDeliveryDate)
                .toList());
                //.collect(Collectors.toList()));

        System.out.println("\nArrayDeque of deliveryDates");
        System.out.println(fruits.stream()
                .map(Fruit::getDeliveryDate)
                .collect(Collectors.toCollection(ArrayDeque::new)));

        System.out.println("\nMap by prices");
        System.out.println(fruits.stream()
                .collect(Collectors.toMap(Fruit::getPrice, Function.identity(), (fr1, fr2) -> fr2)));

        System.out.println("\nAll fruit names in one row");
        System.out.println(fruits.stream()
                .map(fr -> fr.getFruitType()
                        .toString())
                .distinct()
                .collect(Collectors.joining("-", "@@@", "$$$")));

        System.out.println("\nGroup by fruit types");
        System.out.println(fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitType)));

        System.out.println("\nGroup by frequency type");
        Map<String, Long> counted = fruits.stream()
                .map(fr -> fr.getFruitType()
                        .toString())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(counted);
    }

    private static List<Fruit> fillFruitsList() {
        List<Fruit> fruits = new ArrayList<>();

        Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(List.of(B, C));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit.setVitamins(List.of(A, C));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(List.of(A, B1, B2, C));
        fruits.add(fruit);

        fruit = new Fruit(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);
        fruit.setVitamins(List.of(E, B, A));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);
        fruit.setVitamins(List.of(A, C, D));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(List.of(A, B, B1, B2, P));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);
        fruit.setVitamins(List.of(B1, B2, P));
        fruits.add(fruit);

        fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(List.of(B, C));
        fruits.add(fruit);

        return fruits;
    }
}
