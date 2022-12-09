package lesson05.builder;

/**
 * @author spasko
 */
public class BuilderExample {
	private String name;
	private String surname;
	private int old;

	private BuilderExample(Builder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
		this.old = builder.old;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String name;
		private String surname;
		private int old;

		private Builder() {
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withSurname(String surname) {
			this.surname = surname;
			return this;
		}

		public Builder withOld(int old) {
			this.old = old;
			return this;
		}

		public BuilderExample build() {
			return new BuilderExample(this);
		}
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getOld() {
		return old;
	}

	@Override
	public String toString() {
		return "BuilderExample [name=" + name + ", surname=" + surname + ", old=" + old + "]";
	}

}
