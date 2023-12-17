package ru.mts;

import java.math.BigDecimal;

/**
 * The type Cat.
 */
public class Cat extends Pet implements Animal{

    /**
     * Instantiates a new Cat.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     */
    public Cat(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
