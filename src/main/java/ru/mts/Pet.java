package ru.mts;

import java.math.BigDecimal;

/**
 * The type Pet.
 */
abstract public class Pet extends AbstractAnimal{
    /**
     * Instantiates a new Pet.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     */
    public Pet(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
