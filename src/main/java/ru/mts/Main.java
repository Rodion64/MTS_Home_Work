package ru.mts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mts.config.Config;
import ru.mts.repository.AnimalsRepository;
import ru.mts.repository.AnimalsRepositoryImpl;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AnimalsRepository animalsRepository = context.getBean(AnimalsRepositoryImpl.class);


        animalsRepository.findLeapYearNames();
        System.out.println();

        int age = 5;
        animalsRepository.findOlderAnimal(age);
        System.out.println();

        System.out.println(Arrays.toString(animalsRepository.findDuplicate().stream().toArray()));
        System.out.println();

        animalsRepository.printDuplicate();
    }

}

