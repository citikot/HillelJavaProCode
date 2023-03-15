package lesson35.spring.basics.part2.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component
@Lazy
public class Kakadu {
    private String name;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Kakadu(@Value("DefaultName") String name, @Value("1") int weight) {
        this.name = name;
        this.weight = weight;
        System.out.println("In constructor " + this);
    }

    @PostConstruct
    private void init() {
        name = this.getClass()
                .getSimpleName();
        System.out.println("In init method " + this);
    }

    @Override
    public String toString() {
        return "Kakadu [name=" + name + ", weight=" + weight + "]";
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("In preDestroy method. " + this + " will be died =(");
    }
}
