package ru.mts;

import ru.mts.animals.Animal;
import ru.mts.animals.Cat;
import ru.mts.create.CreateAnimalService;
import ru.mts.create.CreateAnimalServiceImpl;

import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
        CreateAnimalService createAnimalService = new CreateAnimalServiceImpl();
        createAnimalService.createAnimals();
        createAnimalService.createAnimals(5);
        CreateAnimalService createAnimalService1 = new CreateAnimalService() {
            @Override
            public void createAnimals(int count) {

            }

            @Override
            public Animal createAnimal() {

                return new Cat("Сфинкс", "Афоня", random(100), "Злой");
            }

            @Override
            public void createAnimals() {
                CreateAnimalService.super.createAnimals();
            }

            private BigDecimal random(int range) {
                BigDecimal max = new BigDecimal(range);
                BigDecimal randFromDouble = new BigDecimal(Math.random());
                BigDecimal actualRandomDec = randFromDouble.multiply(max);
                actualRandomDec = actualRandomDec.setScale(2, BigDecimal.ROUND_DOWN);
                return actualRandomDec;
            }
        };
        createAnimalService1.createAnimals();

    }
}
