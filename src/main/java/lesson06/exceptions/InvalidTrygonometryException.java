package lesson06.exceptions;

public class InvalidTrygonometryException extends RuntimeException {

    public InvalidTrygonometryException() {
        super();
    }

    public InvalidTrygonometryException(Number number) {
        super("Value of " + number + " doesn't supported in current trygonomerty operation");
    }
}
