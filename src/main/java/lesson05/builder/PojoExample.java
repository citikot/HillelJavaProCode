package lesson05.builder;

/**
 * @author spasko
 */
public class PojoExample {
	private String name;
	private String surname;
	private int old;

	public PojoExample(String name, String surname, int old) {
		this.name = name;
		this.surname = surname;
		this.old = old;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	@Override
	public String toString() {
		return "PojoExample [name=" + name + ", surname=" + surname + ", old=" + old + "]";
	}

}
