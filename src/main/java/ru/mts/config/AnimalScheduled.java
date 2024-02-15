
package ru.mts.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.repository.AnimalsRepositoryImpl;

import java.util.Arrays;

@Component
public class AnimalScheduled {
    private final AnimalsRepositoryImpl animalsRepository;

    public AnimalScheduled(AnimalsRepositoryImpl animalsRepository) {
        this.animalsRepository = animalsRepository;
    }


    @Scheduled( fixedDelayString = "${fixedRate}")
    public void doMain() {
        animalsRepository.findLeapYearNames();
        System.out.println();

        int age = 1;
        animalsRepository.findOlderAnimal(age);
        System.out.println();

        System.out.println(Arrays.toString(animalsRepository.findDuplicate().stream().toArray()));
        System.out.println();

        animalsRepository.printDuplicate();
    }
}