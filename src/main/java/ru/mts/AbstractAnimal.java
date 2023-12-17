package ru.mts;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The type Abstract animal.
 */
abstract public class AbstractAnimal implements Animal {
    /**
     * The Breed.
     */
    protected String breed;
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Cost.
     */
    protected BigDecimal cost;
    /**
     * The Character.
     */
    protected String character;

    /**
     * Instantiates a new Abstract animal.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     */
    public AbstractAnimal(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
        this.character = character;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

}
