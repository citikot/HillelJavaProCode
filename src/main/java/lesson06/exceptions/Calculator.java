package lesson06.exceptions;

/**
 * @author spasko
 */
public class Calculator {

    private Calculator() {
    }

    public static int div(int a, int b) {
        int result = -666;
        try {
            result = a / b;
        } catch (Exception e) {
            System.out.println("Exception when div working " + e.getMessage());
        }
        return result;
    }

    public static double sqrt(int a) throws NegativeValueException {
        if (a < 0) {
            throw new NegativeValueException(a);
        }
        return Math.sqrt(a);
    }

    public static double acos(double cos) {
        if (Math.abs(cos) > 1) {
            throw new InvalidTrygonometryException(cos);
        }
        return Math.acos(cos);
    }

    public static double asin(double asin) {
        if (Math.abs(asin) > 1) {
            throw new InvalidTrygonometryException(asin);
        }
        if (asin == 0) {
            throw new IllegalArgumentException("We hate 0 asin");
        }
        return Math.acos(asin);
    }
}
