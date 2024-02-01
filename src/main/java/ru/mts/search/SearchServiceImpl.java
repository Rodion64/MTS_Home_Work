package ru.mts.search;


import ru.mts.animals.Animal;

import java.time.LocalDate;
import java.util.*;

/**
 * The type Search service.
 */
public class SearchServiceImpl implements SearchService {
    @Override
    public String[] findLeapYearNames(Animal[] animals) {
        Optional<Animal[]> optionalObj = Optional.ofNullable(animals);
        optionalObj.orElseThrow(() -> new NullPointerException("Argument is null"));
        List<String> names = new ArrayList<>();
        for (Animal animal : animals) {
            int year = animal.getBirthday().getYear();
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                names.add(animal.getName());
            }
        }
        System.out.println("Животные, родившиеся в високосный год:");
        for (String name : names) {
            System.out.println(name);
        }
        return names.toArray(new String[0]);
    }

    @Override
    public Animal[] findOlderAnimal(Animal[] animals, int age) {
        if (age < 0) {
            throw new IllegalArgumentException(String.format("Incorrect arguments: [%s]", age));
        }
        Optional<Animal[]> optionalObj = Optional.ofNullable(animals);
        optionalObj.orElseThrow(() -> new NullPointerException("Argument is null"));
        List<Animal> olderAnimals = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Animal animal : animals) {
            LocalDate birthDate = animal.getBirthday();
            int years = currentDate.getYear() - birthDate.getYear();
            if (birthDate.plusYears(years).isAfter(currentDate)) {
                years--;
            }
            if (years > age) {
                olderAnimals.add(animal);
            }
        }
        System.out.printf("Животные, возраст которых старше %s лет:%n", age);
        for (Animal animal : olderAnimals) {
            System.out.println(animal.getName() + " (" + animal.getBirthday().getYear() + ")");
        }
        return olderAnimals.toArray(new Animal[0]);
    }

    @Override
    public void findDuplicate(Animal[] animals) {
        Optional<Animal[]> optionalObj = Optional.ofNullable(animals);
        optionalObj.orElseThrow(() -> new NullPointerException("Argument is null"));
        Set<Animal> set = new HashSet<>();
        int t = 0;
        for (Animal animal : animals) {
            if (!set.add(animal)) {
                System.out.println("Дубликат: " + animal.getName());
                t++;
            }
        }
        if (t == 0) {
            System.out.println("Дубликаты не найдены !");
        }
    }

}
