package ru.mts.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.mts.animals.Animal;
import ru.mts.animals.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SearchServiceImplTest {

    @Test
    @DisplayName("findLeapYearNamesTrue")
    public void testFindLeapYearNames_Positive() {
        LocalDate birthday = LocalDate.of(2012, 1, 1);
        LocalDate birthday2 = LocalDate.of(2010, 1, 1);
        Animal[] animals = {
                new Dog("Bulldog", "Max1", new BigDecimal("1000.00"), "Friendly", birthday),
                new Dog("Bulldog", "Max2", new BigDecimal("1000.00"), "Friendly", birthday2),
                new Dog("Bulldog", "Max3", new BigDecimal("1000.00"), "Friendly", birthday2),
                new Dog("Bulldog", "Max4", new BigDecimal("1000.00"), "Friendly", birthday)
        };
        SearchService searchService = new SearchServiceImpl();
        assertNotEquals(new String[]{}, searchService.findLeapYearNames(animals));
    }

    @Test
    @DisplayName("findLeapYearNamesNull")
    public void testFindLeapYearNames_NullArgument() {
        Animal[] animals = null;
        SearchService searchService = new SearchServiceImpl();
        assertThrows(NullPointerException.class, () -> searchService.findLeapYearNames(animals));
    }

    @Test
    @DisplayName("findLeapYearNames_NoAnimals()")
    public void testFindLeapYearNames_NoAnimals() {
        Animal[] animals = new Animal[0];
        SearchService searchService = new SearchServiceImpl();
        assertArrayEquals(new String[]{}, searchService.findLeapYearNames(animals));

    }

    @Test
    @DisplayName("testFindOlderAnimal_NegativeAge()")
    public void testFindOlderAnimal_NegativeAge() {
        LocalDate birthday = LocalDate.of(2012, 1, 1);
        LocalDate birthday2 = LocalDate.of(2010, 1, 1);
        Animal[] animals = {
                new Dog("Bulldog", "Max1", new BigDecimal("1000.00"), "Friendly", birthday),
                new Dog("Bulldog", "Max2", new BigDecimal("1000.00"), "Friendly", birthday2),
                new Dog("Bulldog", "Max3", new BigDecimal("1000.00"), "Friendly", birthday2),
                new Dog("Bulldog", "Max4", new BigDecimal("1000.00"), "Friendly", birthday)
        };
        int age = -1;
        SearchService searchService = new SearchServiceImpl();
        assertThrows(IllegalArgumentException.class, () -> searchService.findOlderAnimal(animals, age));
    }

    @Test
    @DisplayName("testFindOlderAnimal_NullAnimals")
    public void testFindOlderAnimal_NullAnimals() {
        Animal[] animals = null;
        int age = 5;
        SearchService searchService = new SearchServiceImpl();
        assertThrows(NullPointerException.class, () -> searchService.findOlderAnimal(animals, age));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 13})
    @DisplayName("testFindOlderAnimal_CorrectResult")
    public void testFindOlderAnimal_CorrectResult(int age) {
        LocalDate birthday = LocalDate.of(2012, 1, 1);
        LocalDate birthday2 = LocalDate.of(2010, 1, 1);
        Animal[] animals = {
                new Dog("Bulldog", "Max1", new BigDecimal("1000.00"), "Friendly", birthday),
                new Dog("Bulldog", "Max2", new BigDecimal("1000.00"), "Friendly", birthday2),
                new Dog("Bulldog", "Max3", new BigDecimal("1000.00"), "Friendly", birthday2),
                new Dog("Bulldog", "Max4", new BigDecimal("1000.00"), "Friendly", birthday)
        };
        SearchService searchService = new SearchServiceImpl();
        searchService.findOlderAnimal(animals, age);
    }

    @Test
    @DisplayName("testFindOlderAnimal_EmptyResult()")
    public void testFindOlderAnimal_EmptyResult() {
        LocalDate birthday = LocalDate.of(2012, 1, 1);
        LocalDate birthday2 = LocalDate.of(2020, 1, 1);
        Animal[] animals = {
                new Dog("Bulldog", "Max1", new BigDecimal("1000.00"), "Friendly", birthday),
                new Dog("Bulldog", "Max2", new BigDecimal("1000.00"), "Friendly", birthday2),
                new Dog("Bulldog", "Max3", new BigDecimal("1000.00"), "Friendly", birthday2),
                new Dog("Bulldog", "Max4", new BigDecimal("1000.00"), "Friendly", birthday)
        };
        SearchService searchService = new SearchServiceImpl();
        int age = 10;
        Animal[] olderAnimals = searchService.findOlderAnimal(animals, age);
        assertNotNull(olderAnimals);
        assertEquals(2, olderAnimals.length);
    }

    @Test
    @DisplayName("Should throw NullPointerException when animals array is null")
    public void testFindDuplicate_NullAnimals() {
        Animal[] animals = null;
        SearchService searchService = new SearchServiceImpl();
        assertThrows(NullPointerException.class, () -> searchService.findDuplicate(animals));
    }

    @Test
    @DisplayName("Should print duplicates when there are duplicates in the array")
    public void testFindDuplicate_PrintDuplicates() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        Animal[] animals = {
                new Dog("Bulldog", "Max1", new BigDecimal("1000.00"), "Friendly", birthday),
                new Dog("Bulldog", "Max2", new BigDecimal("1000.00"), "Friendly", birthday),
                new Dog("Bulldog", "Max1", new BigDecimal("1000.00"), "Friendly", birthday),
                new Dog("Bulldog", "Max4", new BigDecimal("1000.00"), "Friendly", birthday)
        };
        SearchService searchService = new SearchServiceImpl();
        searchService.findDuplicate(animals);
    }

}