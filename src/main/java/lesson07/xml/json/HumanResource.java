package lesson07.xml.json;

/**
 * @author spasko
 */
public class HumanResource extends Person {
    private int startWorkYear;

    public HumanResource() {
        super();
    }

    public HumanResource(String name, String surname, int yearOfBorn, int startWorkYear) {
        super(name, surname, yearOfBorn);
        this.startWorkYear = startWorkYear;
    }

    public int getStartWorkYear() {
        return startWorkYear;
    }

    public void setStartWorkYear(int startWorkYear) {
        this.startWorkYear = startWorkYear;
    }

    @Override
    public String toString() {
        return "HumanResource [startWorkYear=" + startWorkYear + ", " + super.toString() + "]";
    }

}
