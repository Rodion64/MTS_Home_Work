package ru.mts;

import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        createAnimalService.createAnimals();
        createAnimalService.createAnimals(5);
        createAnimalService.getHashSet();
    }
}
