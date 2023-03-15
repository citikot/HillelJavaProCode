package lesson35.spring.basics.part2.component;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component
public class Panda {

    private String name;
    private String voice;
    private String street;
    private String city;
    private String country;

    @Autowired
    private Tiger tiger;

    public Panda() {
        System.out.println("Constructor finished creating panda instance");
    }

    @PostConstruct
    private void init() {
        name = "Panda";
        // Same to tiger
        voice = tiger.getVoice();
        street = "SpringGreen";
        city = "Pekin";
        country = "China";
    }

    public String getName() {
        return name;
    }

    public String getVoice() {
        return voice;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Panda [name=" + name + ", voice=" + voice + ", street=" + street + ", city=" + city + ", country="
                + country + "]";
    }

}
