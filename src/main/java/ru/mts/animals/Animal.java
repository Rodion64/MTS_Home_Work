package ru.mts.animals;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The interface Animal.
 */
public interface Animal {
    /**
     * ����� ���������� ������ ���������
     *
     * @return the breed
     */
    String getBreed();

    /**
     * ����� ���������� ��� ���������
     *
     * @return the name
     */
    String getName();

    /**
     * ����� ���������� ���� ��������� � ��������
     *
     * @return the cost
     */
    BigDecimal getCost();

    /**
     * ����� ���������� �������� ���������
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
