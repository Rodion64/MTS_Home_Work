package ru.mts.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Dog.
 */
public class Dog extends Pet {
    /**
     * Instantiates a new Dog.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     * @param birthday  the birthday
     */
    public Dog(String breed, String name, BigDecimal cost, String character, LocalDate birthday) {
        super(breed, name, cost, character, birthday);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
