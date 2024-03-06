package ru.mts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mts.entity.Animal;
import ru.mts.repository.AnimalsRepositoryImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnimalScheduled {
    @Autowired
    private final AnimalsRepositoryImpl animalsRepository;

    public AnimalScheduled(AnimalsRepositoryImpl animalsRepository) {
        this.animalsRepository = animalsRepository;
    }


    @Scheduled(fixedRateString = "${application.scheduler.time}")
    public void doMain() {

        System.out.println(animalsRepository.findLeapYearNames().toString());
        System.out.println("-------------------------------------------------------");
        System.out.println(animalsRepository.findOlderAnimal(100).toString());
        System.out.println("-------------------------------------------------------");
        System.out.println(animalsRepository.findDuplicate());
        System.out.println("-------------------------------------------------------");
        animalsRepository.printDuplicate();
        System.out.println("-------------------------------------------------------");

        List<Animal> animalList;
        animalList = animalsRepository.convertUsingForLoop();

        animalsRepository.findAverageAge(animalList);
        System.out.println("-------------------------------------------------------");
        System.out.println(animalsRepository.findOldAnimalExpensive(animalList));
        System.out.println("-------------------------------------------------------");
        System.out.println(animalsRepository.findMinConstAnimals(animalList));



    }
}