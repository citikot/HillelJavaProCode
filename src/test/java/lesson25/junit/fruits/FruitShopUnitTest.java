package lesson25.junit.fruits;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author spasko
 */
class FruitShopUnitTest {
    private FruitShop fruitShop;
    private List<Fruit> fruits;
    private static Fruit apple;
    private static Fruit pear;
    private static Fruit strawberry;
    private static Fruit orange;

    @BeforeAll
    static void beforeClass() {
        System.out.println("BeforeClass MainJunitTest.class");
        apple = new Fruit(FruitType.APPLE, 50, LocalDate.of(2019, Month.JANUARY, 10), 7, null);
        pear = new Fruit(FruitType.PEAR, 40, LocalDate.of(2019, Month.JANUARY, 11), 25, null);
        strawberry = new Fruit(FruitType.STRAWBERRY, 10, LocalDate.of(2018, Month.DECEMBER, 29), 80, null);
        orange = new Fruit(FruitType.ORANGE, 50, LocalDate.of(2018, Month.DECEMBER, 1), 30, null);
    }

    @AfterAll
    static void afterClass() {
        System.out.println("AfterClass MainJunitTest.class");
    }

    @BeforeEach
    void initTest() {
        System.out.println("Before MainJunitTest.class");
        fruits = new ArrayList<>();
        fruits.add(apple);
        fruits.add(pear);
        fruits.add(strawberry);
        fruits.add(orange);
        fruitShop = new FruitShop("Our test shop", fruits);
    }

    @AfterEach
    void afterTest() {
        System.out.println("After MainJunitTest.class");
        fruitShop = null;
    }

    @Test
    void testAllFresh() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, Month.FEBRUARY, 28));
        assertEquals(expected, actual);
    }

    @Test
    void allFreshShouldBeNothing() {
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2099, Month.FEBRUARY, 28));
        assertEquals(0, actual.size());
    }

    @Test
    void allFreshDateNull() {
        assertThrows(NullPointerException.class, () -> fruitShop.allFresh(null));
    }

    @Test
    void allFreshAndFruitType() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(orange);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.ORANGE, LocalDate.of(2019, Month.JANUARY, 12));
        assertEquals(expected, actual);
    }

    @Test
    void allFreshAndFruitTypeShouldBeNothing() {
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.PEAR, LocalDate.of(2099, Month.FEBRUARY, 28));
        assertEquals(0, actual.size());

        actual = fruitShop.allFreshAndFruitType(null, LocalDate.of(2019, Month.JANUARY, 12));
        assertEquals(0, actual.size());
    }

    @ParameterizedTest
    @EnumSource(FruitType.class)
    void allFruitOfFruitType(FruitType fruitType) {
        List<Fruit> actual = fruitShop.allFruitOfFruitType(fruitType);
        List<Fruit> expected = fruits.stream()
                .filter(f -> f.getFruitType() == fruitType)
                .toList();
        
        assertEquals(expected, actual);
    }

    // ...all others tests
}
