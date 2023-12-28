package ru.mts.animals;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Wolf.
 */
public class Wolf extends Predator {

    /**
     * Instantiates a new Predator.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     * @param birthday  the birthday
     */
    public Wolf(String breed, String name, BigDecimal cost, String character, LocalDate birthday) {
        super(breed, name, cost, character, birthday);
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
