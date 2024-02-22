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


@SpringBootTest(classes = AnimalsRepositoryImpl.class)
@ActiveProfiles("test")
@Import(MockConfiguration.class)
class AnimalsRepositoryImplTest {
    @Autowired
    AnimalsRepository animalsRepository;

    @Test
    @DisplayName("Тест работу findLeapYearNames в поизитовном сценарии")
    public void findLeapYearNamesTest() {

        String[] leapYearNames = animalsRepository.findLeapYearNames();

        Assertions.assertEquals(2, leapYearNames.length);
    }

    @Test
    @DisplayName("Тест работу метода findLeapYearNames в негативном сценарии")
    public void findLeapYearNamesTestNegtive() {
        String[] leapYearNames = animalsRepository.findLeapYearNames();
        Assertions.assertNotEquals(0, leapYearNames.length);
    }

    @Test
    @DisplayName("Тест метода findOlderAnimalTest")
    public void findOlderAnimalTest() {
        int age = 11;
        Animal[] olderAnimal = animalsRepository.findOlderAnimal(age);
        Assertions.assertEquals(2, olderAnimal.length);
    }

    @Test
    @DisplayName("Тест метода findOlderAnimalTest с недопустимым аргументов")
    public void findOlderAnimalTestNegative() throws IllegalArgumentException {
        int age = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalsRepository.findOlderAnimal(age));
    }


    @Test
    @DisplayName("Тест на поиск дубликатов методом findDuplicate")
    public void findDuplicate() {
        Assertions.assertEquals(2, animalsRepository.findDuplicate().size());

    }

    @Test
    @DisplayName("Тест printDuplicate")
    public void printDuplicate() {
        animalsRepository.printDuplicate();
    }

}
