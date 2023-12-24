package ru.mts.search;

import ru.mts.animals.Animal;

/**
 * The interface Search service.
 */
public interface SearchService {
    /**
     * Находит всех животных, которые родились в високосный год
     *
     * @param animals массив животных
     * @return массив имен животных, которые родились в високосный год
     */
    String[] findLeapYearNames(Animal[] animals);

    /**
     * Находит всех животных, возраст которых старше N лет
     *
     * @param animals массив животных
     * @param age     возраст в годах
     * @return массив животных, возраст которых старше N лет
     */
    Animal[] findOlderAnimal(Animal[] animals, int age);

    /**
     * Находит дубликаты животных и выводит их на экран
     *
     * @param animals массив животных
     */
    void findDuplicate(Animal[] animals);
}
