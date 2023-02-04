package lesson20.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author spasko
 */
public class MainReflection {

    public static void main(String[] args) {
        try {
            Animal animal = new Animal("Kitten", 1);
            System.out.println(animal);

            System.out.println("\nGet all fields");
            Field[] allFields = Animal.class.getDeclaredFields();
            System.out.println(Arrays.toString(allFields));

            System.out.println("\nInvoking private field");
            Field privateField = Animal.class.getDeclaredField("name");
            privateField.setAccessible(true);
            privateField.set(animal, "New name for Cat");
            System.out.println(animal);

            System.out.println("\nGet all methods");
            Method[] allMethods = Animal.class.getDeclaredMethods();
            System.out.println(Arrays.toString(allMethods));

            System.out.println("\nInvoking private method");
            Method method = Animal.class.getDeclaredMethod("someInternalLogic");
            method.setAccessible(true);
            method.invoke(animal);
            System.out.println(animal);

            System.out.println("\nGet all constructors");
            Constructor<?>[] allConstructors = Animal.class.getDeclaredConstructors();
            System.out.println(Arrays.toString(allConstructors));

            System.out.println("\nInvoking private constructor");
            Constructor<?> constructor = Animal.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            animal = (Animal) constructor.newInstance();
            System.out.println(animal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
