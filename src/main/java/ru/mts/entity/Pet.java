package ru.mts.entity;


import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Pet.
 */
abstract public class Pet extends AbstractAnimal {

    /**
     * Instantiates a new Pet.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     * @param birthday  the birthday
     */
    public Pet(String breed, String name, BigDecimal cost, String character, LocalDate birthday) {
        super(breed, name, cost, character, birthday);
    }
}
