package lesson35.spring.basics.part2.advanced;

import lesson35.spring.basics.part2.component.Kakadu;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component
public class KakaduBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Kakadu) {
            System.out.println("In postProcessAfterInitialization " + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Kakadu) {
            System.out.println("In postProcessBeforeInitialization " + bean);
        }
        return bean;
    }

}
