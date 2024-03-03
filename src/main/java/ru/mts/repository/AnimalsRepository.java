package ru.mts.repository;

import ru.mts.entity.Animal;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public interface AnimalsRepository {

    Map<String, LocalDate> findLeapYearNames();


    Map<Animal, Integer> findOlderAnimal(int N);

    Map<String, Integer> findDuplicate();

   void printDuplicate();
}
