package ru.mts.create;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.mts.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * The type Create service animal factory.
 */
public class CreateServiceAnimalFactoryImpl implements CreateService {

    private AnimalTypes animalType;

    public void setAnimalType(AnimalTypes animalType) {
        this.animalType = animalType;
    }

    @Value("${names}")
    String[] names;


    @Override
    public Map<String, List<Animal>> createAnimals() {
        int n = 10;
        Map<String, List<Animal>> animals = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            String name = generateName(random, names);
            BigDecimal cost = BigDecimal.valueOf(random.nextDouble() * 1000);
            String character = generateCharacter(random);
            LocalDate birthday = generateBirthDate(random);
            List<Animal> animal = null;
            switch (animalType) {
                case Cat:
                    String breedCat = generateBreedCat(random);
                    animals.putIfAbsent(animalType.toString(), new ArrayList<>());
                    animals.get(animalType.toString()).add(new Cat(breedCat, name, cost, character, birthday));
                    break;
                case Wolf:
                    String breedWolf = generateBreedWolf(random);
                    animals.putIfAbsent(animalType.toString(), new ArrayList<>());
                    animals.get(animalType.toString()).add(new Wolf(breedWolf, name, cost, character, birthday));
                    break;
                case Dog:
                    String breedDog = generateBreedDog(random);
                    animals.putIfAbsent(animalType.toString(), new ArrayList<>());
                    animals.get(animalType.toString()).add(new Dog(breedDog, name, cost, character, birthday));
                    break;
                case Tiger:
                    String breedTiger = generateBreedTiger(random);
                    animals.putIfAbsent(animalType.toString(), new ArrayList<>());
                    animals.get(animalType.toString()).add(new Tiger(breedTiger, name, cost, character, birthday));
            }

        }
        return animals;
    }


    public void printAnimals(Animal[] animals) {
        Optional<Animal[]> optionalObj = Optional.ofNullable(animals);
        optionalObj.orElseThrow(() -> new NullPointerException(String.format("Argument is null")));
        Arrays.stream(animals).forEach(s -> System.out.println(s.toString()));
    }
    private String generateName(Random random, String[] names) {

        return names[random.nextInt(names.length)];
    }

    private String generateCharacter(Random random) {
        String[] characters = {"Friendly", "Aggressive", "Lazy", "Active", "Smart", "Stupid", "Calm", "Nervous", "Curious", "Independent"};
        return characters[random.nextInt(characters.length)];
    }

    private String generateBreedCat(Random random) {
        String[] catBreeds = {"Siamese", "British Shorthair", "Persian", "Scottish Fold", "Maine Coon", "Bengal", "Sphynx", "Russian Blue", "American Wirehair", "Savannah"};
        return catBreeds[random.nextInt(catBreeds.length)];
    }

    private String generateBreedWolf(Random random) {
        String[] wolfBreeds = {"Gray wolf", "Red wolf", "Arctic wolf", "Mexican wolf", "White wolf", "Eurasian wolf", "Black wolf", "Red wolf", "Grey wolf", "Tunguska wolf"};
        return wolfBreeds[random.nextInt(wolfBreeds.length)];
    }

    private String generateBreedTiger(Random random) {
        String[] tigerBreeds = {"Bengal tiger", "Sumatran tiger", "Siberian tiger", "Malayan tiger", "Vietnamese tiger", "Chinese tiger", "Korean tiger", "Bali tiger", "Javanese tiger", "Caspian tiger"};
        return tigerBreeds[random.nextInt(tigerBreeds.length)];
    }

    private String generateBreedDog(Random random) {
        String[] dogBreeds = {"Labrador Retriever", "German Shepherd", "French Bulldog", "Beagle", "Jack Russell Terrier", "Shih Tzu", "Yorkshire Terrier", "Chihuahua", "Doberman", "Rottweiler"};
        return dogBreeds[random.nextInt(dogBreeds.length)];
    }


    private LocalDate generateBirthDate(Random random) {
        int year = 2010 + random.nextInt(12);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        return LocalDate.of(year, month, day);
    }

}
