package ru.mts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mts.entity.Animal;
import ru.mts.exceptions.IllegalListException;
import ru.mts.exceptions.IllegalValueException;
import ru.mts.repository.AnimalsRepositoryImpl;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class AnimalScheduled {
    @Autowired
    private final AnimalsRepositoryImpl animalsRepository;

    public AnimalScheduled(AnimalsRepositoryImpl animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @PostConstruct
    public void init() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // Поток для метода printDuplicate()
        Runnable printDuplicateTask = () -> {
            System.out.println(Thread.currentThread().getName() + " thread started");
            animalsRepository.printDuplicate();
            System.out.println(Thread.currentThread().getName() + " thread finished");
        };
        executor.scheduleAtFixedRate(printDuplicateTask, 0, 10, TimeUnit.SECONDS);

        // Поток для метода findAverageAge()
        Runnable findAverageAgeTask = () -> {
            System.out.println(Thread.currentThread().getName() + " thread started");
            try {
                animalsRepository.findAverageAge(animalsRepository.getAnimalList());
            } catch (IllegalListException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " thread finished");
        };
        executor.scheduleAtFixedRate(findAverageAgeTask, 0, 20, TimeUnit.SECONDS);
    }

    @Scheduled(fixedRateString = "${application.scheduler.time}")
    public void doMain() {
        try {
            System.out.println(animalsRepository.findLeapYearNames().toString());
            System.out.println("-------------------------------------------------------");
            System.out.println(animalsRepository.findOlderAnimal(10).toString());
            System.out.println("-------------------------------------------------------");
            System.out.println(animalsRepository.findDuplicate());
            System.out.println("-------------------------------------------------------");
            animalsRepository.printDuplicate();
            System.out.println("-------------------------------------------------------");
            List<Animal> animalList;
            animalList = animalsRepository.getAnimalList();
            animalsRepository.findAverageAge(animalList);
            System.out.println("-------------------------------------------------------");
            System.out.println(animalsRepository.findOldAnimalExpensive(animalList));
            System.out.println("-------------------------------------------------------");
            System.out.println(animalsRepository.findMinConstAnimals(animalList));
        } catch (IllegalListException | IllegalValueException e) {
            System.out.println(e);
        }

    }
}