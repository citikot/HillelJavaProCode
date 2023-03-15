package lesson35.spring.basics.part1.component;

import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component("dog")
public class Dog extends AbstractAnimal {

    @Override
    public String getVoice() {
        return "Gav-gav";
    }

}
