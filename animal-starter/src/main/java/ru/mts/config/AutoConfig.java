package ru.mts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.create.CreateService;
import ru.mts.create.CreateServiceAnimalFactoryImpl;


@Configuration
@ComponentScan(basePackages = "ru.mts")
public class AutoConfig  {
@Bean
@Scope(value = "prototype")
    CreateServiceAnimalFactoryImpl createServiceAnimalFactory(){
        return new CreateServiceAnimalFactoryImpl();
    }
}