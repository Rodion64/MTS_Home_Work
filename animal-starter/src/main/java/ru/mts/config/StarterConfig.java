package ru.mts.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.create.AnimalTypes;
import ru.mts.create.CreateService;
import ru.mts.create.CreateServiceAnimalFactoryImpl;


@Configuration
@ComponentScan(basePackages = "ru.mts")
public class StarterConfig implements BeanPostProcessor {
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

    @Bean
    @Scope(value = "prototype")
    public CreateService createService() {
        return new CreateServiceAnimalFactoryImpl();
    }

}