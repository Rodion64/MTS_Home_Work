package ru.mts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mts.create.CreateService;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.repository.AnimalsRepository;
import ru.mts.repository.AnimalsRepositoryImpl;

@Configuration
@ComponentScan(basePackages = "ru.mts")
public class Config {
    @Bean
    @Scope(value = "prototype")
    public CreateService createService(CreateServiceAnimalFactoryImpl createServiceAnimalFactory) {
        return new CreateServiceAnimalFactoryImpl();
    }

    @Bean
    public AnimalsRepository animalsRepository(CreateServiceAnimalFactoryImpl createAnimalService) {
        return new AnimalsRepositoryImpl(createAnimalService);
    }
}