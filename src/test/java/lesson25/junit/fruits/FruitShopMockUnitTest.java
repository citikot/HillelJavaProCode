package lesson25.junit.fruits;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author spasko
 */
@ExtendWith(MockitoExtension.class)
class FruitShopMockUnitTest {
    @InjectMocks
    private FruitShop fruitShop;
    @Mock
    private List<Fruit> fruits;
    @Mock
    private Fruit apple;
    @Mock
    private Fruit pear;
    @Mock
    private Fruit strawberry;
    @Mock
    private Fruit orange;

    @BeforeEach
    void setUp() {
        createFruitMock(apple, LocalDate.of(2019, Month.JANUARY, 10), 50);
        createFruitMock(pear, LocalDate.of(2019, Month.JANUARY, 11), 40);
        createFruitMock(strawberry, LocalDate.of(2018, Month.DECEMBER, 29), 10);
        createFruitMock(orange, LocalDate.of(2018, Month.DECEMBER, 1), 50);

        when(fruits.stream()).thenReturn(Stream.of(apple, pear, strawberry, orange));
    }

    private void createFruitMock(Fruit fruit, LocalDate date, int timeTolive) {
        when(fruit.getDeliveryDate()).thenReturn(date);
        when(fruit.getDayToLive()).thenReturn(timeTolive);
    }

    @Test
    void allFresh() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit(apple));
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, Month.FEBRUARY, 28));

        verify(apple, times(2)).getDeliveryDate();
        assertEquals(expected, actual);
    }
    
    // ...all others tests
}
