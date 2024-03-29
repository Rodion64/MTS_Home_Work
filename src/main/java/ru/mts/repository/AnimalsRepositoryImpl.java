package ru.mts.repository;

import org.springframework.stereotype.Repository;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.entity.Animal;
import ru.mts.exceptions.IllegalListException;
import ru.mts.exceptions.IllegalValueException;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {
    private Map<String, List<Animal>> animals = new ConcurrentHashMap<>();
    private final CreateServiceAnimalFactoryImpl createServiceAnimalFactory;

    public AnimalsRepositoryImpl(CreateServiceAnimalFactoryImpl createServiceAnimalFactory) {
        this.createServiceAnimalFactory = createServiceAnimalFactory;
    }

    @PostConstruct
    public void init() {
        animals = createServiceAnimalFactory.createAnimals();
    }


    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        Optional.ofNullable(animals).orElseThrow(() -> new RuntimeException("Map is empty"));
        return animals.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .filter(animal -> checkLeapYear(animal.getBirthday().getYear()))
                        .map(animal -> {
                            String key = animal.getClass().getSimpleName() + " " + animal.getName();
                            return Map.entry(key, animal.getBirthday());
                        }))
                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(int age) throws IllegalValueException {
        if (age < 0) {
            throw new IllegalValueException(String.format("Incorrect arguments: [%s]/n", age));
        }
        Optional.ofNullable(animals).orElseThrow(() -> new RuntimeException("Map is empty"));
        LocalDate currentDate = LocalDate.now();
        Map<Animal, Integer> animalIntegerMap = new ConcurrentHashMap<>();
        animals.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .forEach(animal -> {
                    Period ageDifference = Period.between(animal.getBirthday(), currentDate);
                    if (ageDifference.getYears() > age) {
                        animalIntegerMap.put(animal, ageDifference.getYears());
                    }
                });
        if (animalIntegerMap.isEmpty()) {
            Animal olderAnimal = animals.entrySet().stream()
                    .flatMap(entry -> entry.getValue().stream())
                    .min(Comparator.comparing(Animal::getBirthday))
                    .orElse(null);
            assert olderAnimal != null;
            int yearsDifference = Period.between(olderAnimal.getBirthday(), currentDate).getYears();
            animalIntegerMap.put(olderAnimal, yearsDifference);
        }
        return animalIntegerMap;
    }

    @Override
    public Map<String, List<Animal>> findDuplicate() {
        Set<Animal> animalsSet = ConcurrentHashMap.newKeySet();
        return animals.values().parallelStream()
                .flatMap(List::stream)
                .filter(animal -> !animalsSet.add(animal))
                .collect(Collectors.groupingByConcurrent(animal -> animal.getClass().getSimpleName(),
                        ConcurrentHashMap::new, Collectors.toList()));
    }

    @Override
    public void printDuplicate() {
        Map<String, List<Animal>> duplicates = findDuplicate();
        if (!duplicates.isEmpty()) {
            System.out.println("Duplicate animals:");
            duplicates.forEach((className, animalsList) -> {
                System.out.println("Class: " + className);
                animalsList.forEach(animal -> System.out.println(animal.toString()));
            });
        } else {
            System.out.println("No duplicates found");
        }
    }

    public List<Animal> convertUsingForLoop() {
        if (animals == null) {
            return null;
        }
        List<Animal> animalList = new CopyOnWriteArrayList<>();
        for (Map.Entry<String, List<Animal>> entry : animals.entrySet()) {
            List<Animal> arrayAnimal = entry.getValue();
            for (int i = 0; i < arrayAnimal.size(); i++) {
                animalList.add(i, arrayAnimal.get(i));
            }
        }
        return animalList;
    }

    @Override
    public void findAverageAge(List<Animal> animalLists) throws IllegalListException {
        if (animalLists == null || animalLists.isEmpty()) {
            throw new IllegalListException("List of animals is null or empty");
        }
        System.out.println("Average age: " + animalLists.stream()
                .map(Animal::getBirthday)
                .map(a -> Period.between(a, LocalDate.now()).getYears())
                .mapToInt(Integer::intValue)
                .average().orElseThrow(() -> new IllegalStateException("No animals to calculate average age"))
        );
    }

    @Override
    public List<Animal> findOldAnimalExpensive(List<Animal> animalLists) throws IllegalListException {
        if (animalLists == null || animalLists.isEmpty()) {
            throw new IllegalListException("List of animals is null or empty");
        }
        BigDecimal averageCost = animalLists.stream()
                .map(Animal::getCost)
                .map(Objects::requireNonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(animalLists.size()), RoundingMode.UP);
        return animalLists.stream()
                .filter(animal -> Period.between(animal.getBirthday(), LocalDate.now()).getYears() > 5)
                .filter(animal -> animal.getCost().compareTo(averageCost) > 0)
                .sorted((Comparator.comparing(Animal::getBirthday)))
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }

    @Override
    public List<String> findMinConstAnimals(List<Animal> animalLists) throws IllegalListException {
        if (animalLists == null) {
            throw new IllegalListException("List is null");
        } else if (animalLists.size() < 3) {
            throw new IllegalListException("List size is less than 3");
        }
        return animalLists.stream()
                .sorted(Comparator.comparing(Animal::getCost))
                .limit(3)
                .sorted(Comparator.comparing(Animal::getName).reversed())
                .map(Animal::getName)
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }


    private boolean checkLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}

