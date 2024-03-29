package ru.mts.postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import ru.mts.create.AnimalTypes;
import ru.mts.create.CreateServiceAnimalFactoryImpl;


@Configuration
public class PostProcess implements BeanPostProcessor {
    @Override

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CreateServiceAnimalFactoryImpl) {
            CreateServiceAnimalFactoryImpl createAnimalService = (CreateServiceAnimalFactoryImpl) bean;
            createAnimalService.setAnimalType(AnimalTypes.randomAnimalTypes());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
