package ru.mts.repository;

import ru.mts.entity.Animal;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AnimalsRepository {

    Map<String, LocalDate> findLeapYearNames();


    Map<Animal, Integer> findOlderAnimal(int N);

    Map<String, List<Animal>> findDuplicate();
    void printDuplicate();

    void findAverageAge(List<Animal> animalLists);
     List<Animal> findOldAnimalExpensive(List<Animal> animalLists);
     List<Animal> findMinConstAnimals(List<Animal> animalLists);

}
