package ru.mts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mts.config.AutoConfig;
import ru.mts.create.CreateService;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.entity.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AutoConfig.class)
public class AnimalStarterTest {

    @Autowired
    private CreateServiceAnimalFactoryImpl createService;

    @Test
    @DisplayName("Тест на соответсвие типа создаваемого животного")
    public void testAnimalType() {
        Map<String, List<Animal>> animals = createService.createAnimals();
        for (Map.Entry<String, List<Animal>> animalEntry : animals.entrySet()) {
            List<Animal> animalList = animalEntry.getValue();
            for (Animal animal : animalList) {
                assertTrue(animal instanceof Cat || animal instanceof Wolf || animal instanceof Dog || animal instanceof Tiger);
            }
        }
    }

    @Test
    @DisplayName("Тест на коректность присваемого имени животного из application.properties")
    public void testAnimalNames() {
        Map<String, List<Animal>> animals = createService.createAnimals();
        boolean flag = false;
        String[] names = {"Barsik", "Myrsik", "Rizik", "Tomas", "Simba", "Leo", "Sherchan", "Marciz", "Mister", "Bazilio", "Kyzma"};
        for (List<Animal> animal : animals.values()) {
            for (int i = 0; i < animal.size(); i++) {
                if (animal.get(i).getName().equals(names[i])) {
                    flag = true;
                    System.out.println(animal.get(i).toString());
                    break;
                }
            }
        }
        System.out.println(animals.toString());

        assertEquals(flag, true);
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
