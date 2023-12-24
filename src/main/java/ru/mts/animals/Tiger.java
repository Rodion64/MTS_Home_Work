package ru.mts.animals;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Tiger.
 */
public class Tiger extends Predator {
    /**
     * Instantiates a new Tiger.
     *
     * @param breed     the breed
     * @param name      the name
     * @param cost      the cost
     * @param character the character
     * @param birthday  the birthday
     */
    public Tiger(String breed, String name, BigDecimal cost, String character, LocalDate birthday) {
        super(breed, name, cost, character, birthday);
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
