package ru.mts.entity;


import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Predator.
 */
abstract public class Predator extends AbstractAnimal {
    /**
     * Instantiates a new Predator.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     * @param birthday  the birthday
     */
    public Predator(String breed, String name, BigDecimal cost, String character, LocalDate birthday) {
        super(breed, name, cost, character, birthday);
    }
}
