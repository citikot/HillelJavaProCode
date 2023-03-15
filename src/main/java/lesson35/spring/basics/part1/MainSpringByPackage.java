package lesson35.spring.basics.part1;

import lesson35.spring.basics.part1.component.Animal;
import lesson35.spring.basics.part1.component.Cat;
import lesson35.spring.basics.part1.component.Dog;
import lesson35.spring.basics.part1.component.Mouse;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author spasko
 */
public class MainSpringByPackage {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
				"lesson35.spring.basics.part1.component");

		Cat cat = context.getBean(Cat.class);
		Dog dog = (Dog) context.getBean("dog");
		Mouse mouse = context.getBean("mouse", Mouse.class);
		
		Animal animal = context.getBean(Animal.class);

		System.out.println(cat);
		System.out.println(dog);
		System.out.println(mouse);
		System.out.println(animal);

		context.close();
	}
}
