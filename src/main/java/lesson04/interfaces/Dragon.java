package lesson04.interfaces;

/**
 * @author spasko
 */
public interface Dragon {
    int thirdInt = 333;

    String name();

    default String createMeat() {
        return "Dragon love animals, with ketchup";
    }

    static String doSomething() {
        return "Fire!";
    }

}
