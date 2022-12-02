package lesson03;

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

}
