package ru.mts.repository;

import ru.mts.entity.Animal;
import ru.mts.exceptions.IllegalListException;
import ru.mts.exceptions.IllegalValueException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * The interface Animals repository.
 */
public interface AnimalsRepository {

	/**
	 * Find leap year names map.
	 *
	 * @return the map
	 */
	ConcurrentMap<String, LocalDate> findLeapYearNames();


	/**
	 * Find older animal map.
	 *
	 * @param N the n
	 * @return the map
	 */
	ConcurrentMap<Animal, Integer> findOlderAnimal(int N) throws IllegalValueException;

	/**
	 * Find duplicate map.
	 *
	 * @return the map
	 */
	ConcurrentMap<String, List<Animal>> findDuplicate();

	/**
	 * Print duplicate.
	 */
	void printDuplicate();

	/**
	 * Find average age.
	 *
	 * @param animalLists the animal lists
	 */
	void findAverageAge(CopyOnWriteArrayList<Animal> animalLists) throws IllegalListException;

	/**
	 * Find old animal expensive list.
	 *
	 * @param animalLists the animal lists
	 * @return the list
	 */
	CopyOnWriteArrayList<Animal> findOldAnimalExpensive(CopyOnWriteArrayList<Animal> animalLists) throws IllegalListException;


	/**
	 * Find min const animals list.
	 *
	 * @param animalLists the animal lists
	 * @return the list
	 */
	CopyOnWriteArrayList<String> findMinConstAnimals(CopyOnWriteArrayList<Animal> animalLists) throws IllegalListException;


}
