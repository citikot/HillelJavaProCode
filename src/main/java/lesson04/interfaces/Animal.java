package lesson04.interfaces;

/**
 * @author spasko
 */
public interface Animal {
    int firstInt = 50;
    int secondInt = 100;
    int thirdInt = 666;

    String name();

    String say();

    default String createMeat() {
        return "We love animals, no-no";
    }

    static String doSomething() {
        return "I am an animal. I would like only sitting on the Sun";
    }

    default boolean eatPeople() {
        return false;
    }
}
