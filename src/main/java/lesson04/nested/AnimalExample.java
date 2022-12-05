package lesson04.nested;

/**
 * @author spasko
 */
public class AnimalExample {
	public static String some="sss";
	public static class Pig implements Animal {

		@Override
		public String name() {
			return "Pig";
		}

		@Override
		public boolean weCanEatIt() {
			return true;
		}

	}

	public class Dog implements Animal {

		@Override
		public String name() {
			return "Dog";
		}

		@Override
		public boolean weCanEatIt() {
			return false;
		}

	}
}
