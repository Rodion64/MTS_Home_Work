package ru.mts.repository;

import org.springframework.stereotype.Repository;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.entity.Animal;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {
    private Map<String, List<Animal>> animals;
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
        Map<String, LocalDate> animalNameMap = new HashMap<>();
        for (Map.Entry<String, List<Animal>> animal : animals.entrySet()) {
            String type = animal.getKey();
            List<Animal> animalList = animal.getValue();
            for (Animal animalNameList : animalList) {
                int year = animalNameList.getBirthday().getYear();
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    String key = type + " " + animalNameList.getName();
                    animalNameMap.put(key, animalNameList.getBirthday());
                }
            }
        }
        return animalNameMap;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(String.format("Incorrect arguments: [%s]/n", age));
        }
        Optional.ofNullable(animals).orElseThrow(() -> new RuntimeException("Map is empty"));
        Map<Animal, Integer> animalIntegerMap = new HashMap<>();
        Animal olderAnimal = null;
        LocalDate currentDate = LocalDate.now();
        int max = 0;
        for (Map.Entry<String, List<Animal>> animalEntry : animals.entrySet()) {
            List<Animal> animalList = animalEntry.getValue();
            for (Animal animal : animalList) {
                int years = currentDate.getYear() - animal.getBirthday().getYear();
                if (years > age) {
                    animalIntegerMap.put(animal, years);
                } else if (years > max) {
                    max = years;
                    olderAnimal = animal;
                }
            }
        }
        if (animalIntegerMap.isEmpty()) {
            animalIntegerMap.put(olderAnimal, max);
        }
        return animalIntegerMap;
    }


    @Override
    public Map<String, Integer> findDuplicate() {
        int i;
        Set<Animal> setAnimals = new HashSet<>();
        Map<String, Integer> duplicate = new HashMap<>();
        for (Map.Entry<String, List<Animal>> animalEntry : animals.entrySet()) {
            String animalType = animalEntry.getKey();
            List<Animal> animalList = animalEntry.getValue();
            for (Animal animal : animalList) {
                if (!setAnimals.add(animal)) {
                    if (duplicate.get(animalType) == null) {
                        i = 1;
                    } else {
                        i = duplicate.get(animalType);
                    }
                    duplicate.put(animalType, ++i);
                }
            }
        }
        return duplicate;
    }


    @Override
    public void printDuplicate() {
        Map<String, Integer> animalSet = findDuplicate();
        if (!animalSet.isEmpty()) {
            System.out.println("Duplicates:");
            for (Map.Entry<String, Integer> entry : animalSet.entrySet()) {
                String entryKey = entry.getKey();
                Integer integer = entry.getValue();
                System.out.println(entryKey + "=" + integer);
            }
        } else {
            System.out.println("No duplicates found");
        }
    }
}
