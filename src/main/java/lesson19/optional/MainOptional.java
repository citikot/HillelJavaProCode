package lesson19.optional;

import java.util.Optional;

/**
 * @author spasko
 */
public class MainOptional {
	public static void main(String[] args) {
		Animal animal1 = new Animal("Cat");
		Animal animal2 = null;

		System.out.println(animal1.getName().toUpperCase());
		// System.out.println(animal2.getName().toUpperCase());

		//Optional<Animal> optionalAnimal = Optional.of(animal2);
		Optional<Animal> optionalAnimal = Optional.ofNullable(animal2);
		
		Optional<Animal> optionalAnimal2 = Optional.of(animal1);
		animal1 = null;
		System.out.println(optionalAnimal2.get());

		System.out.println("\nValue isPresent");
		System.out.println(optionalAnimal.isPresent());

		System.out.println("\nReturn default value if dont present");
		System.out.println(optionalAnimal.orElse(animal1));

		System.out.println("\nReturn default value if dont present from lambda expresiion");
		System.out.println(optionalAnimal.orElseGet(Animal::new));

		System.out.println("\nReturn exception if dont present from lambda expresiion");
		System.out.println(optionalAnimal.orElseThrow(RuntimeException::new));
	}

}