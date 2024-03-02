package ru.mts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mts.repository.AnimalsRepositoryImpl;

import java.util.Arrays;

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
        System.out.println("-------------------------");
        System.out.println(animalsRepository.findOlderAnimal(0).toString());
        System.out.println("-------------------------");
        System.out.println(animalsRepository.findDuplicate());
        System.out.println("-------------------------");
        animalsRepository.printDuplicate();


    }
}