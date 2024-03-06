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
        animalsRepository.findLeapYearNames();
        System.out.println();

        int age = 3;
        animalsRepository.findOlderAnimal(age);
        System.out.println();

        System.out.println(Arrays.toString(animalsRepository.findDuplicate().stream().toArray()));
        System.out.println();

        animalsRepository.printDuplicate();
    }
}