package ru.mts.animals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.mts.animals.AbstractAnimal;
import ru.mts.animals.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
 class AbstractAnimalTest{

    @Test
    /*testEquals_Positive - проверяет корректность сравнения двух объектов Dog, которые имеют одинаковые значения всех полей;*/
    @DisplayName("testEquals_Positive()")
    public void testEquals_Positive() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        Dog dog1 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);
        Dog dog2 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);

        assertTrue(dog1.equals(dog2));
    }


    @Test
    /*testEquals_Negative_Breed - проверяет корректность сравнения двух объектов Dog, которые имеют разные значения поля breed;*/
    @DisplayName("testEquals_Negative_Breed()")
    public void testEquals_Negative_Breed() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        Dog dog1 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);
        Dog dog2 = new Dog("Bulldog2", "Max", new BigDecimal("1000.00"), "Friendly", birthday);

        assertFalse(dog1.equals(dog2));
    }

    @Test
    /*testEquals_Negative_Name - проверяет корректность сравнения двух объектов Dog, которые имеют разные значения поля name;*/
    @DisplayName("testEquals_Negative_Name()")
    public void testEquals_Negative_Name() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        Dog dog1 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);
        Dog dog2 = new Dog("Bulldog", "Max1", new BigDecimal("1000.00"), "Friendly", birthday);

        assertFalse(dog1.equals(dog2));
    }

    @Test
    /*testEquals_Negative_Cost - проверяет корректность сравнения двух объектов Dog, которые имеют разные значения поля cost;*/
    @DisplayName("testEquals_Negative_Cost()")
    public void testEquals_Negative_Cost() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        Dog dog1 = new Dog("Bulldog", "Max", new BigDecimal("2000.00"), "Friendly", birthday);
        Dog dog2 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);

        assertFalse(dog1.equals(dog2));
    }

    @Test
    /*testEquals_Negative_Character - проверяет корректность сравнения двух объектов Dog, которые имеют разные значения поля character;*/
    @DisplayName("testEquals_Negative_Character()")
    public void testEquals_Negative_Character() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        Dog dog1 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly2", birthday);
        Dog dog2 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);

        assertFalse(dog1.equals(dog2));
    }

    @Test
    /*testEquals_Negative_Birthday - проверяет корректность сравнения двух объектов Dog, которые имеют разные значения поля birthday;*/
    @DisplayName("testEquals_Negative_Birthday()")
    public void testEquals_Negative_Birthday() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        LocalDate birthday2 = LocalDate.of(2011, 1, 1);
        Dog dog1 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);
        Dog dog2 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday2);

        assertFalse(dog1.equals(dog2));
    }

    @Test
    /*testEquals_Null - проверяет, что при передаче в метод equals() значение null возвращает false;*/
    @DisplayName("testEquals_Null()")
    public void testEquals_Null() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        Dog dog = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);
        assertFalse(dog.equals(null));
    }

    @Test
    /* testEquals_SameObject - проверяет, что при передаче в метод equals() ссылки на один и тот же объект возвращает true;*/
    @DisplayName("testEquals_SameObject()")
    public void testEquals_SameObject() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        Dog dog = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);

        assertTrue(dog.equals(dog));
    }

    @Test
    /* testEquals_DifferentClass - проверяет, что при передаче в метод equals() объекта другого класса возвращает false.*/
    @DisplayName("testEquals_DifferentClass()")
    public void testEquals_DifferentClass() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        Dog dog = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);
        Object object = new Object();

        assertFalse(dog.equals(object));
    }

    @Test
    /*testHashCodeWithSameFieldsReturnsTrue() - проверяет, что у объектов с одинаковыми полярми равный hashCode одинаковый */
    @DisplayName("testHashCodeWithSameFieldsReturnsTrue()")
    public void testHashCodeWithSameFieldsReturnsTrue() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        AbstractAnimal animal1 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);
        AbstractAnimal animal2 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);
        System.out.println(animal1.hashCode()+ " "+" "+ animal2.hashCode());
        assertEquals(animal1.hashCode(), animal2.hashCode());

    }

    @Test
    /*testHashCodeWithDifferentFieldsReturnsFalse() - проверяет, что у объектов с разными полярми разный hashCode */
    @DisplayName("testHashCodeWithDifferentFieldsReturnsFalse() ")
    public void testHashCodeWithDifferentFieldsReturnsFalse() {
        LocalDate birthday = LocalDate.of(2010, 1, 1);
        AbstractAnimal animal1 = new Dog("Bulldog", "Max", new BigDecimal("1000.00"), "Friendly", birthday);
        AbstractAnimal animal2 = new Dog("Poodle", "Charlie", new BigDecimal("500.00"), "Loyal", birthday);
        System.out.println(animal1.hashCode()+ " "+" "+ animal2.hashCode());
        assertNotEquals(animal1.hashCode(), animal2.hashCode());
    }

}



