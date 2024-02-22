package ru.mts.repository;

import org.springframework.stereotype.Repository;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.entity.Animal;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {
    private Animal[] animals;
    private final CreateServiceAnimalFactoryImpl createServiceAnimalFactory;

    public AnimalsRepositoryImpl(CreateServiceAnimalFactoryImpl createServiceAnimalFactory) {
        this.createServiceAnimalFactory = createServiceAnimalFactory;
    }

    @PostConstruct
    public void init() {
        animals = createServiceAnimalFactory.createAnimals();
    }

    @Override
    public String[] findLeapYearNames() {
        Optional<Animal[]> optionalObj = Optional.ofNullable(animals);
        optionalObj.orElseThrow(() -> new NullPointerException("Argument is null"));
        List<String> names = new ArrayList<>();
        for (Animal animal : animals) {
            int year = animal.getBirthday().getYear();
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                names.add(animal.getName());
            }
        }
        System.out.println("Animals born in the leap year:");
        for (String name : names) {
            System.out.println(name);
        }
        return names.toArray(new String[0]);
    }

    @Override
    public Animal[] findOlderAnimal(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(String.format("Incorrect arguments: [%s]/n", age));
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
        System.out.printf("Animals are older %s years ", age);
        for (Animal animal : olderAnimals) {
            System.out.println(animal.getName() + " (" + animal.getBirthday().getYear() + ")");
        }
        return olderAnimals.toArray(new Animal[0]);
    }

    @Override
    public Set<Animal> findDuplicate() {

        if (animals == null || animals.length == 0 || animals.length == 1) {
            return new HashSet<Animal>();
        }
        Set<Animal> animalsSet = new HashSet<>();
        for (int i = 0; i < animals.length; i++) {

            for (int j = i + 1; j < animals.length; j++) {
                if (animals[i].equals(animals[j])) {
                    animalsSet.add(animals[i]);
                }
            }
        }
        return animalsSet;
    }

    @Override
    public void printDuplicate() {
        Set<Animal> set = findDuplicate();
        if (set.isEmpty())
            System.out.println("No duplicates found");
        for (Animal animal : set) {
            System.out.println("Duplicates: " + animal.getName());
        }
    }
}
