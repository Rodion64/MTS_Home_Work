package ru.mts.animals;

import ru.mts.animals.AbstractAnimal;
import ru.mts.animals.Animal;

import java.math.BigDecimal;

/**
 * The type Predator.
 */
abstract public class Predator extends AbstractAnimal implements Animal {
    /**
     * Instantiates a new Predator.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     */
    public Predator(String breed, String name, BigDecimal cost, String character) {
            super(breed, name, cost, character);
        }

}
