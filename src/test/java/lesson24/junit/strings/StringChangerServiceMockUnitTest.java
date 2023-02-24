package lesson24.junit.strings;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author spasko
 */
@ExtendWith(MockitoExtension.class)
class StringChangerServiceMockUnitTest {

    @InjectMocks
    private StringChangerService stringChangerService;
    @Mock
    private StringLowerUpperService lowerUpperService;

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

    @Test
    void testAddStartUpperInputLower() {
        when(lowerUpperService.toLower(Mockito.anyString())).thenReturn("lovervalue");
        // doReturn("lovervalue").when(lowerUpperService).toLower(Mockito.anyString());
        when(lowerUpperService.toUpper(Mockito.anyString())).thenReturn("UPPERVALUE");
        String expected = "UPPERVALUElovervalue";
        String actual = stringChangerService.addStartUpperInputLower("some", "some");
        assertEquals(expected, actual);
    }

    @Test
    void testAddStartUpperInputLowerWhenStartNull() {
        when(lowerUpperService.toUpper(null)).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, () -> stringChangerService.addStartUpperInputLower(null, "some"));
    }

    // It is not the unittest, but also may be used
    @Test
    void testAddStartAndEndTotalLower() {
        stringChangerService.addStartAndEndTotalLower("sTArt", "eNd", "INput");
        verify(lowerUpperService).toLower("sTArtINputeNd");
    }

    // ...all others tests
}
