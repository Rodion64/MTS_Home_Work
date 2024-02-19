package ru.mts.create;

import java.util.Random;

/**
 * The enum Animal types.
 */
public enum AnimalTypes {
    /**
     * Cat animal types.
     */
    CAT,
    /**
     * Wolf animal types.
     */
    WOLF,
    /**
     * Dog animal types.
     */
    DOG,
    /**
     * Tiger animal types.
     */
    TIGER;

    public static AnimalTypes randomAnimalTypes() {
        return AnimalTypes.values()[new Random().nextInt(AnimalTypes.values().length)];
    }
}
