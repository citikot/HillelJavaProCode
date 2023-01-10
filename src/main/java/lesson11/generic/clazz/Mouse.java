package lesson11.generic.clazz;

/**
 * @author spasko
 */
public class Mouse implements Animal {

    @Override
    public String name() {
        return "Mouse";
    }

    @Override
    public String say() {
        return "Pi";
    }

    @Override
    public String toString() {
        return "Mouse [name()=" + name() + ", say()=" + say() + "]";
    }

}
