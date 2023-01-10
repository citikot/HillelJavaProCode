package lesson11.generic.clazz;

/**
 * @author spasko
 */
public class Cat implements Animal {
	@Override
	public String name() {
		return "Cat";
	}

	@Override
	public String say() {
		return "Murrr";
	}

	@Override
	public String toString() {
		return "Cat [name()=" + name() + ", say()=" + say() + "]";
	}

}
