package lesson35.spring.basics.part1.config;
/**
 * @author spasko
 */

import lesson35.spring.basics.part1.component.AbstractAnimal;
import lesson35.spring.basics.part1.component.Cat;
import lesson35.spring.basics.part1.component.Dog;
import lesson35.spring.basics.part1.component.Mouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//@ComponentScan("lesson35.spring.basics.part1.component")
public class AppConfig {

	@Bean
	public Cat returnCat() {
		return new Cat();
	}

	@Bean("dog")
	@Primary
	public Dog returnDog() {
		return new Dog();
	}

	@Bean("mouse")
	public Mouse returnMouse() {
		return new Mouse();
	}

	@Bean("pig")
	public Pig returnPig() {
		return new Pig();
	}

	//Don't write same
	class Pig extends AbstractAnimal {

		@Override
		public String getVoice() {
			return "Hru-hru";
		}

	}
}
