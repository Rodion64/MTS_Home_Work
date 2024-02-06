package ru.mts.repository;

import ru.mts.entity.Animal;

import java.util.Set;

public interface AnimalsRepository {

    String[] findLeapYearNames();


    Animal[] findOlderAnimal(int N);

    Set<Animal> findDuplicate();


    void printDuplicate();
}
