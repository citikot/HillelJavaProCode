package lesson35.spring.basics.part1.component;

import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component("mouse")
public class Mouse extends AbstractAnimal {

    @Override
    public String getVoice() {
        return "Pi-pi";
    }

}
