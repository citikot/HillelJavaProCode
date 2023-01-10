package lesson11.generic.method;

import java.util.List;
import lesson11.generic.clazz.Cat;
import lesson11.generic.clazz.Dog;
import lesson11.generic.clazz.Mouse;

/**
 * @author spasko
 */
public class MainGenericMethod {
    public static void main(String[] args) {

        GenericMethodExample genericMethodExample = new GenericMethodExample();
        genericMethodExample.doSomething("This is String", "This is String too =) ");
        System.out.println("111----------");

        genericMethodExample.doSomethingWithCat("This is String", new Cat());
        System.out.println("222----------");

        genericMethodExample.showAnimalNames(List.of(new Dog(), new Mouse()));
        System.out.println("333----------");

        genericMethodExample.showCatParentsNames(List.of(new Dog(), new Mouse(), new MainGenericMethod()));
        System.out.println("444----------");

        genericMethodExample.showCatParentsNames(List.of(new Cat(), new Dog()));

    }

}
