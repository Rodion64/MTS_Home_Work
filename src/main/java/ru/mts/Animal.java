package ru.mts;

import java.math.BigDecimal;

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
}
