package ru.mts.animals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.time.LocalDate;
import java.lang.*;

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
     * The Birth date.
     */
    protected LocalDate birthday;


    /**
     * Instantiates a new Abstract animal.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     * @param birthday  the birthdate
     */
    public AbstractAnimal(String breed, String name, BigDecimal cost, String character, LocalDate birthday) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
        this.character = character;
        this.birthday = birthday;
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

    @Override
    public LocalDate getBirthday() {
        return birthday;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) object;
        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name) && Objects.equals(cost, that.cost) && Objects.equals(character, that.character) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthday);
    }
}
