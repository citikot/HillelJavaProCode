package lesson35.spring.basics.part2;

import lesson35.spring.basics.part2.component.Cat;
import lesson35.spring.basics.part2.component.Kakadu;
import lesson35.spring.basics.part2.component.Panda;
import lesson35.spring.basics.part2.component.Tiger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author spasko
 */
public class MainSpring {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("lesson35.spring.basics.part2");

        Tiger bigCat = context.getBean(Tiger.class);
        System.out.println(bigCat);

        Panda panda = context.getBean(Panda.class);
        System.out.println(panda);

        Kakadu kakadu = context.getBean(Kakadu.class);
        System.out.println(kakadu);

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);

        cat = context.getBean(Cat.class);
        System.out.println(cat);

        cat = context.getBean(Cat.class);
        System.out.println(cat);

        context.close();
    }
}
