package ru.mts.create;

import ru.mts.animals.Animal;
import ru.mts.animals.Cat;

import java.math.BigDecimal;

/**
 * The interface Create animal service.
 */
public interface CreateAnimalService {
    /**
     * Метод создает 10 уникальных животных при помощи цикла while
     */
    default void createAnimals() {
        int count = 0;
        while (count < 10) {
            Animal animal = createAnimal();
            String animalInfo = String.format("Created new animal while: " + animal.getBreed() + animal.getName() + animal.getCost() + animal.getCharacter());
            System.out.println(animalInfo);
            count++;
            System.out.println(animal.hashCode());
        }
    }

    /**
     * Метод создает count уникальных животных при помощи цикла for
     *
     * @param count the count
     */
    void createAnimals(int count);

    /**
     * Метод создает новое животное
     *
     * @return the animal
     */
    Animal createAnimal();


}
