package lesson25.junit.fruits;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * @author spasko
 */
public class FruitShop {
    private String name;
    private List<Fruit> fruits;

    public FruitShop(String name, List<Fruit> fruits) {
        this.name = name;
        this.fruits = fruits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    private boolean fruitIsValid(Fruit fruit, LocalDate date, int daysToChange) {
        return date.isAfter(fruit.getDeliveryDate())
                && ChronoUnit.DAYS.between(fruit.getDeliveryDate(), date) <= daysToChange;
    }

    public List<Fruit> allFresh(LocalDate checkDate) {
        return fruits.stream()
                .filter(f -> fruitIsValid(f, checkDate, f.getDayToLive()))
                .toList();
    }

    public List<Fruit> allFruitOfFruitType(FruitType fruitType) {
        return fruits.stream()
                .filter(f -> f.getFruitType()
                        .equals(fruitType))
                .toList();
    }

    public List<Fruit> checkByExpireDate(int checkDays) {
        return fruits.stream()
                .filter(f -> f.getDayToLive() > checkDays)
                .toList();
    }

    public List<Fruit> allFreshAndFruitType(FruitType fruitType, LocalDate expDate) {
        return allFruitOfFruitType(fruitType).stream()
                .filter(f -> fruitIsValid(f, expDate, f.getDayToLive()))
                .toList();
    }

    public List<Fruit> reSetPricexRealization(int percent, int daysToChange, FruitType... fruitTypes) {
        List<FruitType> possibleTypes = Arrays.asList(fruitTypes);
        return fruits.stream()
                .filter(f -> possibleTypes.contains(f.getFruitType()))
                .filter(f -> fruitIsValid(f, LocalDate.now(), daysToChange))
                .map(f -> new Fruit(f.getFruitType(), f.getDayToLive(), f.getDeliveryDate(),
                        f.getPrice() * percent / 100, f.getVitamins()))
                .toList();
    }

}
