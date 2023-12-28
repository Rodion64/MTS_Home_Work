package ru.mts;

import ru.mts.animals.Animal;
import ru.mts.create.AnimalTypes;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.search.SearchService;
import ru.mts.search.SearchServiceImpl;


public class Main {
    public static void main(String[] args) {
        CreateServiceAnimalFactoryImpl animalFactory = new CreateServiceAnimalFactoryImpl();
        Animal[] animals = animalFactory.createAnimals(10, AnimalTypes.WOLF);
        animalFactory.printAnimals(animals);
        SearchService searchService = new SearchServiceImpl();

        // Поиск животных, родившихся в високосный год
        searchService.findLeapYearNames(animals);

        // Поиск животных, возраст которых старше N лет
        searchService.findOlderAnimal(animals, 10);

        // Поиск дубликатов животных
        searchService.findDuplicate(animals);
    }

}

