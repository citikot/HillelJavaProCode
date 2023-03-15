package lesson35.spring.basics.part2.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component
@PropertySource({"classpath:lesson35/spring/basics/part2/pig.properties"})
public class Pig {
    @Value("${voice}")
    private String voice;

    public String getVoice() {
        return voice;
    }

    public String toString() {
        return "Pig say " + getVoice();
    }
}
