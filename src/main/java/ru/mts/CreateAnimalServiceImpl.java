package ru.mts;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Create animal service.
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {
    /**
     * The Hash set.
     */
    public HashSet<Object> hashSet = new HashSet<>();

    /**
     * Get hash set.
     */
    public void getHashSet() {
        for (Object o : this.hashSet) {
            System.out.println(o.toString());
        }
    }
    @Override
    public void createAnimals(int count) {
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                Animal animal = createAnimal();
                String animalInfo = String.format("Created new animal for: %s %s %s %s ",
                        animal.getBreed(), animal.getName(), animal.getCost(), animal.getCharacter());
                System.out.println(animalInfo);
                hashSet.add(animal);
            }
        }
        else{
            throw new IllegalArgumentException(String.format("Incorrect arguments: "+ count));
        }
    }
    @Override
    public Animal createAnimal() {
        return new Cat("Сфинкс", "Афоня", new BigDecimal("1000.568"), "Злой");
    }

    public void createAnimals() {
        int count = 0;
        do {
            count++;
            Animal animal = createAnimal();
            String animalInfo = String.format("Created new animal do-while: %s %s %s %s ",
                    animal.getBreed(), animal.getName(), animal.getCost(), animal.getCharacter());
            System.out.println(animalInfo);
            hashSet.add(animal);
        } while (count < 10);
    }
}
