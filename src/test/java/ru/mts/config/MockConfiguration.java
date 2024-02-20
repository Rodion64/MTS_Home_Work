package ru.mts.config;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.entity.Animal;
import ru.mts.entity.Dog;
import ru.mts.entity.Wolf;

import java.math.BigDecimal;
import java.time.LocalDate;


@Profile("test")
@TestConfiguration

public class MockConfiguration {
    @Bean
    @Primary
    public CreateServiceAnimalFactoryImpl createServiceAnimalFactory() {
        LocalDate birthday = LocalDate.now().minusYears(11).minusMonths(11).minusDays(3);
        LocalDate birthday2 = LocalDate.now().minusYears(12).minusMonths(11).minusDays(3);

        CreateServiceAnimalFactoryImpl mock = Mockito.mock(CreateServiceAnimalFactoryImpl.class);
        Animal[] animals = {
                new Dog("Bulldog", "Myrsik", new BigDecimal("1000.00"), "Friendly", birthday),
                new Dog("Bulldog", "Myrsik", new BigDecimal("1000.00"), "Friendly", birthday),
                new Wolf("Red wolf", "Tomas", new BigDecimal("1000.00"), "Friendly", birthday2),
                new Wolf("Red wolf", "Tomas", new BigDecimal("1000.00"), "Friendly", birthday2)};


        Mockito.when(mock.createAnimals()).thenReturn(animals);
        return mock;
    }
}
