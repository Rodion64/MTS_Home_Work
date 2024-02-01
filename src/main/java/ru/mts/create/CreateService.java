package ru.mts.create;

import ru.mts.animals.Animal;

/**
 * The interface Create service.
 */
public interface CreateService {
    /**
     * Создает массив из n случайных животных
     *
     * @param n    количество животных в массиве
     * @param type the type
     * @return массив животных
     */
    Animal[] createAnimals(int n, AnimalTypes type);
}
