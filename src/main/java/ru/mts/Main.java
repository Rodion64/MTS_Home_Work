package ru.mts;

import ru.mts.animals.Animal;
import ru.mts.create.AnimalTypes;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.search.SearchService;
import ru.mts.search.SearchServiceImpl;
import java.lang.*;


public class Main {
    public static void main(String[] args) {
        CreateServiceAnimalFactoryImpl animalFactory = new CreateServiceAnimalFactoryImpl();
        Animal[] animals = animalFactory.createAnimals(10, AnimalTypes.WOLF);
        animalFactory.printAnimals(animals);
        SearchService searchService = new SearchServiceImpl();

        searchService.findLeapYearNames(animals);

        searchService.findOlderAnimal(animals, 10);

        searchService.findDuplicate(animals);
    }

}


