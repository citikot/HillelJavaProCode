package lesson06.exceptions;

public class NegativeValueException extends Exception {

    public NegativeValueException() {
        super();
    }

    public NegativeValueException(Number number) {
        super("Value of " + number + " is negative, and doesn't supported");
    }

}
