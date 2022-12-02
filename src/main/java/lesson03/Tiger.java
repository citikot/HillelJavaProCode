package lesson03;

/**
 * @author spasko
 */
public class Tiger extends Cat {
    private String personalName;

    public Tiger() {
        personalName = "Barsik";
    }

    public Tiger(String additionalSout) {
        this();
        System.out.println(additionalSout);
    }

    public Tiger(String personalName, String additionalSout) {
        this.personalName = personalName;
        System.out.println(additionalSout);
    }
    
    public Tiger(Cat cat) {
        this(cat.name(), "Mutate to tiger");
    }

    @Override
    public String name() {
        return "Tiger(extra-variant of " + super.name() + ")";
    }

    public String getPersonalName() {
        return personalName;
    }
    
    public Tiger tigerInstance() {
        return this;
    }
}
