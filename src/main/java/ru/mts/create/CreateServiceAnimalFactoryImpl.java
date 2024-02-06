package ru.mts.create;

import org.springframework.stereotype.Component;
import ru.mts.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;


/**
 * The type Create service animal factory.
 */
@Component
public class CreateServiceAnimalFactoryImpl implements CreateService {

    private AnimalTypes animalType;

    public void setAnimalType(AnimalTypes animalType) {
        this.animalType = animalType;
    }



    @Override
    public Animal[] createAnimals() {

        int n = 10;
        Animal[] animals = new Animal[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            String name = generateName(random);
            BigDecimal cost = BigDecimal.valueOf(random.nextDouble() * 1000);
            String character = generateCharacter(random);
            LocalDate birthday = generateBirthDate(random);
            Animal animal = null;
            switch (animalType) {
                case CAT:
                    String breedCat = generateBreedCat(random);
                    animal = new Cat(breedCat, name, cost, character, birthday);
                    break;
                case WOLF:
                    String breedWolf = generateBreedWolf(random);
                    animal = new Wolf(breedWolf, name, cost, character, birthday);
                    break;
                case DOG:
                    String breedDog = generateBreedDog(random);
                    animal = new Dog(breedDog, name, cost, character, birthday);
                    break;
                case TIGER:
                    String breedTiger = generateBreedTiger(random);
                    animal = new Tiger(breedTiger, name, cost, character, birthday);
            }
            animals[i] = animal;
        }

        return animals;
    }

    @Override
    public Animal[] createAnimals(int n, AnimalTypes type) {
        if (n < 0) {
            throw new IllegalArgumentException(String.format("Incorrect arguments: [%s, AnimalTypes type]", n));
        }
        Optional<AnimalTypes> optionalObj = Optional.ofNullable(type);
        optionalObj.orElseThrow(() -> new NullPointerException(String.format("Argument is null: [%s, %s]", n, type)));
        Animal[] animals = new Animal[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            String name = generateName(random);
            BigDecimal cost = BigDecimal.valueOf(random.nextDouble() * 1000);
            String character = generateCharacter(random);
            LocalDate birthday = generateBirthDate(random);
            Animal animal = null;
            switch (type) {
                case CAT:
                    String breedCat = generateBreedCat(random);
                    animal = new Cat(breedCat, name, cost, character, birthday);
                    break;
                case WOLF:
                    String breedWolf = generateBreedWolf(random);
                    animal = new Wolf(breedWolf, name, cost, character, birthday);
                    break;
                case DOG:
                    String breedDog = generateBreedDog(random);
                    animal = new Dog(breedDog, name, cost, character, birthday);
                    break;
                case TIGER:
                    String breedTiger = generateBreedTiger(random);
                    animal = new Tiger(breedTiger, name, cost, character, birthday);
            }
            animals[i] = animal;
        }

        return animals;
    }

    /**
     * Print animals.
     *
     * @param animals the animals
     */
    public void printAnimals(Animal[] animals) {
        Optional<Animal[]> optionalObj = Optional.ofNullable(animals);
        optionalObj.orElseThrow(() -> new NullPointerException(String.format("Argument is null")));
        Arrays.stream(animals).forEach(s -> System.out.println(s.toString()));
    }

    private String generateName(Random random) {
        String[] names = {"Барсик", "Мурзик", "Рыжик", "Томас", "Симба", "Леопольд", "Тайгер", "Шерхан", "Жасмин", "Маркиза", "Мистер Бигглзворт", "Базилио", "Кузьма", "Арчи", "Феликс", "Гарфилд", "Чарли", "Рокки", "Бобик", "Шарик", "Тузик", "Дружок", "Рекс", "Ласка", "Зевс", "Аполлон", "Тор", "Халк", "Локи", "Геркулес"};
        return names[random.nextInt(names.length)];
    }

    private String generateCharacter(Random random) {
        String[] characters = {"Дружелюбный", "Агрессивный", "Ленивый", "Активный", "Умный", "Глупый", "Спокойный", "Нервный", "Любопытный", "Независимый"};
        return characters[random.nextInt(characters.length)];
    }

    private String generateBreedCat(Random random) {
        String[] catBreeds = {"Сиамская", "Британская короткошерстная", "Персидская", "Шотландская вислоухая", "Мейн-кун", "Бенгальская", "Сфинкс", "Русская голубая", "Американская жесткошерстная", "Саванна"};
        return catBreeds[random.nextInt(catBreeds.length)];
    }

    private String generateBreedWolf(Random random) {
        String[] wolfBreeds = {"Серый волк", "Красный волк", "Арктический волк", "Мексиканский волк", "Белый волк", "Евразийский волк", "Черный волк", "Рыжий волк", "Серый волк", "Тунгусский волк"};
        return wolfBreeds[random.nextInt(wolfBreeds.length)];
    }

    private String generateBreedTiger(Random random) {
        String[] tigerBreeds = {"Бенгальский тигр", "Суматранский тигр", "Амурский тигр", "Малайский тигр", "Вьетнамский тигр", "Китайский тигр", "Корейский тигр", "Балийский тигр", "Яванский тигр", "Каспийский тигр"};
        return tigerBreeds[random.nextInt(tigerBreeds.length)];
    }

    private String generateBreedDog(Random random) {
        String[] dogBreeds = {"Лабрадор ретривер", "Немецкая овчарка", "Французский бульдог", "Бигль", "Джек Рассел терьер", "Ши-тцу", "Йоркширский терьер", "Чихуахуа", "Доберман", "Ротвейлер"};
        return dogBreeds[random.nextInt(dogBreeds.length)];
    }


    private LocalDate generateBirthDate(Random random) {
        int year = 2010 + random.nextInt(12);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        return LocalDate.of(year, month, day);
    }

}
