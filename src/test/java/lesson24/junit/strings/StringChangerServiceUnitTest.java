package lesson24.junit.strings;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author spasko
 */
class StringChangerServiceUnitTest {
    private StringChangerService stringChangerService;

    @BeforeAll
    static void beforeClass() {
        System.out.println("BeforeClass MainJunitTest.class");
    }

    @AfterAll
    static void afterClass() {
        System.out.println("AfterClass MainJunitTest.class");
    }

    @BeforeEach
    void initTest() {
        System.out.println("Before MainJunitTest.class");
        StringLowerUpperService lowerUpperService = new StringLowerUpperService();
        stringChangerService = new StringChangerService(lowerUpperService);
    }

    @AfterEach
    void afterTest() {
        System.out.println("After MainJunitTest.class");
    }

    @Test
    void testAddEnd() {
        String expected = "MainStrEndString";
        String actual = stringChangerService.addEnd("EndString", "MainStr");
        assertEquals(expected, actual);
    }

    @Test
    void testAddEndWhenInputNull() {
        String expected = "nullEndString";
        String actual = stringChangerService.addEnd("EndString", null);
        assertEquals(expected, actual);
    }

    @Test
    void testAddEndWhenEndNull() {
        String expected = "MainStrnull";
        String actual = stringChangerService.addEnd(null, "MainStr");
        assertEquals(expected, actual);
    }

    @Test
    void testAddEndWhenEndEqualsInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> stringChangerService.addEnd("string", "string"));
        assertEquals("Doesn't work with end.equals(input)", exception.getMessage());
    }

    // ...all others tests
}
