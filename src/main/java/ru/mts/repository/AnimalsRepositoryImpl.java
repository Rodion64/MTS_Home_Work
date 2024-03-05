package ru.mts.repository;

import org.springframework.stereotype.Repository;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.entity.Animal;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

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

        return animals.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .filter(animal -> {
                            int year = animal.getBirthday().getYear();
                            return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
                        })
                        .map(animal -> {
                            String key = entry.getKey() + " " + animal.getName();
                            return Map.entry(key, animal.getBirthday());
                        }))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    @Override
    public Map<Animal, Integer> findOlderAnimal(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(String.format("Incorrect arguments: [%s]/n", age));
        }

        Optional.ofNullable(animals).orElseThrow(() -> new RuntimeException("Map is empty"));

        LocalDate currentDate = LocalDate.now();

        Map<Animal, Integer> animalIntegerMap = animals.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .filter(animal -> currentDate.getYear() - animal.getBirthday().getYear() > age)
                        .map(animal -> Map.entry(animal, currentDate.getYear() - animal.getBirthday().getYear())))
                .collect(HashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), HashMap::putAll);

        if (animalIntegerMap.isEmpty()) {
            Animal olderAnimal = animals.entrySet().stream()
                    .flatMap(entry -> entry.getValue().stream())
                    .reduce((animal1, animal2) -> currentDate.getYear() - animal1.getBirthday().getYear() > currentDate.getYear() - animal2.getBirthday().getYear() ? animal1 : animal2)
                    .orElse(null);

            int max = currentDate.getYear() - olderAnimal.getBirthday().getYear();
            animalIntegerMap.put(olderAnimal, max);
        }

        return animalIntegerMap;
    }


    public Map<String, List<Animal>> findDuplicate() {
        Set<Animal> animalsSet = new HashSet<>();

        return animals.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .filter(animal -> !animalsSet.add(animal))
                .collect(Collectors.groupingBy(animal -> animal.getClass().getSimpleName(), Collectors.toList()));
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
        List<Animal> animalList = new ArrayList<>();
        for (Map.Entry<String, List<Animal>> entry : animals.entrySet()) {
            List<Animal> arrayAnimal =  entry.getValue();
            for (int i =0; i< arrayAnimal.size();i++){
                animalList.add(i,arrayAnimal.get(i));
            }
        }
        return animalList;
    }

    public void findAverageAge(List<Animal> animalLists) {
        System.out.println("Average age: "+ animalLists.stream()
                .map(Animal::getBirthday)
                .map(a -> Period.between(a, LocalDate.now()).getYears())
                .mapToInt(Integer::intValue)
                .average().orElse(0)
        );
    }


    public List<Animal> findOldAnimalExpensive(List<Animal> animalLists) {
        BigDecimal sumOfCost = animalLists.stream()
                .map(Animal::getCost)
                .map(Objects::requireNonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal averageCost = sumOfCost.divide(new BigDecimal(animalLists.size()), RoundingMode.UP);
        return animalLists.stream()
                .filter(animal -> Period.between(animal.getBirthday(), LocalDate.now()).getYears() > 5)
                .filter(animal -> animal.getCost().compareTo(averageCost) > 0)
                .sorted((Comparator.comparing(Animal::getBirthday)))
                .collect(Collectors.toList());
    }


    public List<Animal> findMinConstAnimals(List<Animal> animalLists) {
        return animalLists.stream()
                .sorted(Comparator.comparing(Animal::getCost))
                .limit(3)
                .sorted(Comparator.comparing(Animal::getName).reversed())
                .collect(Collectors.toList());
    }

    private void validateAnimals() {
        if (animals == null) {
            throw new IllegalArgumentException("Animals array cannot be null");
        }
        Set<String> keysMap = animals.keySet();
        for (String key : keysMap) {
            List<Animal> animalsList = animals.get(key);
            for (Animal animal : animalsList) {
                if (animal == null) {
                    throw new IllegalArgumentException("Some animal is null");
                }
            }
        }

    }
}
