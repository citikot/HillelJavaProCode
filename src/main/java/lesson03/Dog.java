package lesson03;
/**
 * @author spasko
 */
public class Dog implements Animal {

	@Override
	public String name() {
		return "Dog";
	}

	@Override
	public String say() {
		return "Gav!";
	}

}
