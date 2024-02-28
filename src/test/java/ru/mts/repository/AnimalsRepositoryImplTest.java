package ru.mts.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.config.MockConfiguration;
import ru.mts.entity.Animal;

import java.time.LocalDate;
import java.util.Map;


@SpringBootTest(classes = AnimalsRepositoryImpl.class)
@ActiveProfiles("test")
@Import(MockConfiguration.class)
class AnimalsRepositoryImplTest {
    @Autowired
    AnimalsRepository animalsRepository;

    @Test
    @DisplayName("Тест работу findLeapYearNames в поизитовном сценарии")
    public void findLeapYearNamesTest() {
        Map<String, LocalDate> leapYearNames = animalsRepository.findLeapYearNames();
        System.out.println(leapYearNames.toString());
        Assertions.assertEquals(2, leapYearNames.size());
    }

    @Test
    @DisplayName("Тест работу метода findLeapYearNames в негативном сценарии")
    public void findLeapYearNamesTestNegtive() {
        Map<String, LocalDate> leapYearNames = animalsRepository.findLeapYearNames();
        System.out.println(leapYearNames.toString());
        Assertions.assertNotEquals(0, leapYearNames.size());
    }

    @Test
    @DisplayName("Тест метода findOlderAnimalTest")
    public void findOlderAnimalTest() {
        int age = 12;
        Map<Animal, Integer> olderAnimal = animalsRepository.findOlderAnimal(age);
        System.out.println(olderAnimal.toString());
        Assertions.assertEquals(2, olderAnimal.size());
    }

    @Test
    @DisplayName("Тест метода findOlderAnimalTest с недопустимым аргументов")
    public void findOlderAnimalTestNegative() throws IllegalArgumentException {
        int age = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalsRepository.findOlderAnimal(age));
    }

    @Test
    @DisplayName("Тест метода findOlderAnimalTest с выводом самого старшего животного")
    public void findOlderAnimalTes() throws IllegalArgumentException {
        int age = 50;
        Map<Animal, Integer> olderAnimal = animalsRepository.findOlderAnimal(age);
        System.out.println(olderAnimal.toString());
        Assertions.assertEquals(1, olderAnimal.size());
    }


    @Test
    @DisplayName("Тест на поиск дубликатов методом findDuplicate")
    public void findDuplicate() {
        System.out.println(animalsRepository.findDuplicate().toString());
        Assertions.assertEquals(2, animalsRepository.findDuplicate().size());

    }

    @Test
    @DisplayName("Тест printDuplicate")
    public void printDuplicate() {
        animalsRepository.printDuplicate();
    }


}
