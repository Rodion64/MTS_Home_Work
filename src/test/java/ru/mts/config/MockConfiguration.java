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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;


@Profile("test")
@TestConfiguration
public class MockConfiguration {
    @Bean
    @Primary
    public CreateServiceAnimalFactoryImpl createServiceAnimalFactory() {
        LocalDate birthday = LocalDate.now().minusYears(11).minusMonths(11).minusDays(3);
        LocalDate birthday2 = LocalDate.now().minusYears(12).minusMonths(11).minusDays(3);
        LocalDate birthday3 = LocalDate.now().minusYears(20);
        CreateServiceAnimalFactoryImpl mock = Mockito.mock(CreateServiceAnimalFactoryImpl.class);
        ConcurrentMap<String, List<Animal>> animals = new ConcurrentHashMap<>();

        CopyOnWriteArrayList<Animal> animalListDog = new CopyOnWriteArrayList<>();
        animalListDog.add(new Dog("Bulldog", "Myrsik", new BigDecimal("1000.00"), "Friendly", birthday));
        animalListDog.add(new Dog("Bulldog", "Oldest", new BigDecimal("1000.00"), "Friendly", birthday3));
        CopyOnWriteArrayList<Animal> animalListWolf = new CopyOnWriteArrayList<>();
        animalListWolf.add(new Wolf("Red wolf", "Tomas", new BigDecimal("1000.00"), "Friendly", birthday2));
        animalListWolf.add(new Wolf("Red wolf", "Tomas", new BigDecimal("1000.00"), "Friendly", birthday2));
        animals.put("Dog", animalListDog);
        animals.put("Wolf", animalListWolf);
        Mockito.when(mock.createAnimals()).thenReturn((ConcurrentMap<String, List<Animal>>) animals);
        return mock;
    }
}
