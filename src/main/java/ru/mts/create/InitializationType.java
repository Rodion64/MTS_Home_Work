package ru.mts.create;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InitializationType implements BeanPostProcessor {

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
