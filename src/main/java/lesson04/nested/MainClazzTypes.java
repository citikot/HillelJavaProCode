package lesson04.nested;

import java.util.ArrayList;
import java.util.List;

/**
 * @author spasko
 */
public class MainClazzTypes {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        String nameNestedClass = "Cat";
        Animal animal1 = new Animal() {

            @Override
            public boolean weCanEatIt() {
                return false;
            }

            @Override
            public String name() {
                return nameNestedClass;
            }
        };
        //You can not change it 
        //nameNestedClass="";
        animals.add(animal1);

        Animal animal2 = new AnimalExample.Pig();
        animals.add(animal2);

        //Haven't access directly, without instance of parent class 
        //Animal animal3 = new AnimalExample.Dog();
        //animals.add(animal3);

        //Cannot create static nested class from instance of parent class
        AnimalExample animalExample = new AnimalExample();
        //animalExample.new Dog();
        //animalExample.new Pig();

        Animal animal4 = new AnimalExample().new Dog();
        animals.add(animal4);

        animals.stream()
                .map(animal -> animal.name() + " - we can eat it? -" + (animal.weCanEatIt() ? "Y" : "N"))
                .forEach(System.out::println);
        ;
    }

}
