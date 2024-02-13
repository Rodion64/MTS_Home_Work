package ru.mts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.repository.AnimalsRepositoryImpl;

@Configuration
public class AnimalRepositoryImplConfig {

    @Bean
    public AnimalsRepositoryImpl animalsRepository(CreateServiceAnimalFactoryImpl createAnimalService) {
        return new AnimalsRepositoryImpl(createAnimalService);
    }
}
