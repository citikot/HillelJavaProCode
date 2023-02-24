package lesson24.junit.strings;

/**
 * @author spasko
 */
public class StringChangerService {
    private StringLowerUpperService lowerUpperService;

    public StringChangerService(StringLowerUpperService lowerUpperService) {
        this.lowerUpperService = lowerUpperService;
    }

    public String addStart(String start, String input) {
        if (start != null && start.equals(input)) {
            throw new IllegalArgumentException("Don\'t work with start.equals(input)");
        }
        return start + input;
    }

    public String addEnd(String end, String input) {
        if (end != null && end.equals(input)) {
            throw new IllegalArgumentException("Doesn\'t work with end.equals(input)");
        }
        return input + end;
    }

    public String addStartUpperInputLower(String start, String input) {
        return lowerUpperService.toUpper(start) + lowerUpperService.toLower(input);
    }

    public String addStartAndEnd(String start, String end, String input) {
        return addStart(start, input) + end;
    }

    public String addStartAndEndUpper(String start, String end, String input) {
        return addStart(start, input) + lowerUpperService.toUpper(end);
    }

    public String addStartAndEndTotalLower(String start, String end, String input) {
        return lowerUpperService.toLower(addStart(start, input) + end);
    }
}
