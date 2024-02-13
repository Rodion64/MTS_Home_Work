package ru.mts.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Cat.
 */
public class Cat extends Pet {

    /**
     * Instantiates a new Cat.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     */
    public Cat(String breed, String name, BigDecimal cost, String character, LocalDate birthday) {
        super(breed, name, cost, character, birthday);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
