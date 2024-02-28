package ru.mts.create;

import java.util.Random;

/**
 * The enum Animal types.
 */
public enum AnimalTypes {
    /**
     * Cat animal types.
     */
    Cat,
    /**
     * Wolf animal types.
     */
    Wolf,
    /**
     * Dog animal types.
     */
    Dog,
    /**
     * Tiger animal types.
     */
    Tiger;

    public static AnimalTypes randomAnimalTypes() {
        return AnimalTypes.values()[new Random().nextInt(AnimalTypes.values().length)];
    }
}
