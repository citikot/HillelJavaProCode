package lesson35.spring.basics.part1.component;

/**
 * @author spasko
 */
public abstract class AbstractAnimal implements Animal {

    @Override
    public String getName() {
        return this.getClass()
                .getSimpleName();
    }

    @Override
    public String toString() {
        return "AbstractAnimal [getName()=" + getName() + ", getVoice()=" + getVoice() + "]";
    }

}
