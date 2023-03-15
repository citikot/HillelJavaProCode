package lesson35.spring.basics.part2.advanced;

import lesson35.spring.basics.part2.component.Tiger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component
public class TigerConfigBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(Tiger.class);
        bd.getPropertyValues()
                .add("voice", "MURNAV!!!");

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("tiger", bd);
    }
}