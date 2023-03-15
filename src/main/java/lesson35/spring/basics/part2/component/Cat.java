package lesson35.spring.basics.part2.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component
public class Cat {
    @Autowired
    private Bloha bloha;

    private String catId;

    public Cat() {
        catId = "Cat " + (int) (Math.random() * 1000);
    }

    @Override
    public String toString() {
        return "Cat [bloha=" + bloha + ", catId=" + catId + "]";
    }

}
