package ru.mts.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The interface Animal.
 */
public interface Animal {
    /**
     * Метод возвращает породу животного
     *
     * @return the breed
     */
    String getBreed();

    /**
     * Метод возвращает имя животного
     *
     * @return the name
     */
    String getName();

    /**
     * Метод возвращает цену животного в магазине
     *
     * @return the cost
     */
    BigDecimal getCost();

    /**
     * Метод возвращает характер животного
     *
     * @return the character
     */
    String getCharacter();

    /**
     * Gets birthdate.
     *
     * @return the birthdate
     */
    LocalDate getBirthday();
}
