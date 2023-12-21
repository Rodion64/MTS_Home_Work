package ru.mts.animals;

import java.math.BigDecimal;

public class Wolf extends Predator {

    /**
     * Instantiates a new Predator.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     */
    public Wolf(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
