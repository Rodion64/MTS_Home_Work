package ru.mts.create;

import ru.mts.animals.Animal;
import ru.mts.animals.Cat;

import java.math.BigDecimal;
import java.util.HashSet;

/**
 * The type Create animal service.
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {
    /**
     * The Hash set.
     */
    private HashSet<Object> hashSet = new HashSet<>();

    /**
     * Get hash set.
     */
    public void getHashSet() {
        for (Object o : this.hashSet) {
            System.out.println(o.hashCode());
        }
    }
    @Override
    public Animal createAnimal() {

        return new Cat("Сфинкс", "Афоня", random(100), "Злой");
    }

    private static BigDecimal random(int range) {
        BigDecimal max = new BigDecimal(range);
        BigDecimal randFromDouble = new BigDecimal(Math.random());
        BigDecimal actualRandomDec = randFromDouble.multiply(max);
        actualRandomDec = actualRandomDec.setScale(2, BigDecimal.ROUND_DOWN);
        return actualRandomDec;
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
                System.out.println(animal.hashCode());
            }
        }
        else{
            throw new IllegalArgumentException(String.format("Incorrect arguments: "+ count));
        }
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
            System.out.println(animal.hashCode());
        } while (count < 10);
    }
}
