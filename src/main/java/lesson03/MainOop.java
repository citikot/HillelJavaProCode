package lesson03;

import java.util.stream.Stream;

/**
 * @author spasko
 */
public class MainOop {
    public static void main(String[] args) {
        Animal[] animals = {new Cat(), new Dog(), new Kitten(), new Mouse(), new Tiger()};
        Stream.of(animals)
                .map(an -> an.name() + " say:" + an.say())
                .forEach(System.out::println);
    }
}
