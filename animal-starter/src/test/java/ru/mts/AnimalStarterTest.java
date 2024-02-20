package ru.mts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mts.config.AutoConfig;
import ru.mts.create.CreateService;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.entity.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AutoConfig.class)
public class AnimalStarterTest {

    @Autowired
    private CreateServiceAnimalFactoryImpl createService;

    @Test
    @DisplayName("Тест на соответсвие типа создаваемого животного")
    public void testAnimalType() {
        Animal[] animals = createService.createAnimals();
        for (Animal animal : animals) {
            assertTrue(animal instanceof Cat || animal instanceof Wolf || animal instanceof Dog || animal instanceof Tiger);
        }
    }

    @Test
    @DisplayName("Тест на коректность присваемого имени животного из application.properties")
    public void testAnimalNames() {
        Animal[] animals = createService.createAnimals();
        String[] names = {"Barsik", "Myrsik", "Rizik", "Tomas", "Simba", "Leo", "Sherchan", "Marciz", "Mister", "Bazilio", "Kyzma"};
        for (Animal animal : animals) {
            if (animal.getName().equals(Arrays.stream(names).findAny()) == true)
                assertTrue(true);
        }
    }

    @Test
    @DisplayName("Тест на самостоятельное создание животных")
    public void testCreate() {
        CreateService animalService = new CreateServiceAnimalFactoryImpl();
        assertThrows(NullPointerException.class, () -> animalService.createAnimals());
    }

    @Test
    @DisplayName("Тест на NullPointerException при типом создаваемого животного null ")
    public void testCreateServiceNullType() {
        createService.setAnimalType(null);
        assertThrows(NullPointerException.class,
                () -> createService.createAnimals());
    }

}
