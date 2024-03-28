package ru.mts.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import ru.mts.config.MockConfiguration;
import ru.mts.create.CreateServiceAnimalFactoryImpl;
import ru.mts.entity.Animal;
import ru.mts.entity.Dog;
import ru.mts.entity.Wolf;
import ru.mts.exceptions.IllegalListException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;


@SpringBootTest(classes = AnimalsRepositoryImpl.class)
@ActiveProfiles("test")
@Import(MockConfiguration.class)
class AnimalsRepositoryImplTest {
	@Autowired
	AnimalsRepository animalsRepository;
	static CopyOnWriteArrayList<Animal> animalList = new CopyOnWriteArrayList<>();


	@BeforeAll
	public static void init() {

		LocalDate birthday = LocalDate.now().minusYears(11).minusMonths(11).minusDays(3);
		LocalDate birthday2 = LocalDate.now().minusYears(12).minusMonths(11).minusDays(3);

		animalList.add(new Dog("Bulldog", "Myrsik", new BigDecimal("1000.00"), "Friendly", birthday));

		animalList.add(new Wolf("Red wolf", "Tomas", new BigDecimal("1000.00"), "Friendly", birthday2));

	}

	@Test
	@DisplayName("Тест работу findLeapYearNames в поизитовном сценарии")
	public void findLeapYearNamesTest() {
		Map<String, LocalDate> leapYearNames = animalsRepository.findLeapYearNames();
		System.out.println(leapYearNames.toString());
		Assertions.assertEquals(2, leapYearNames.size());
	}

	@Test
	@DisplayName("Тест работу метода findLeapYearNames в негативном сценарии")
	public void findLeapYearNamesTestNegtive() {
		Map<String, LocalDate> leapYearNames = animalsRepository.findLeapYearNames();
		System.out.println(leapYearNames.toString());
		Assertions.assertNotEquals(0, leapYearNames.size());
	}

	@Test
	@DisplayName("Тест метода findOlderAnimalTest")
	public void findOlderAnimalTest() {
		int age = 12;
		Map<Animal, Integer> olderAnimal = animalsRepository.findOlderAnimal(age);
		System.out.println(olderAnimal.toString());
		Assertions.assertEquals(1, olderAnimal.size());
	}

	@Test
	@DisplayName("Тест метода findOlderAnimalTest с недопустимым аргументов")
	public void findOlderAnimalTestNegative() throws IllegalArgumentException {
		int age = -1;
		Assertions.assertThrows(IllegalArgumentException.class, () -> animalsRepository.findOlderAnimal(age));
	}

	@Test
	@DisplayName("Тест метода findOlderAnimalTest с выводом самого старшего животного")
	public void findOlderAnimalTes() throws IllegalArgumentException {
		int age = 50;
		Map<Animal, Integer> olderAnimal = animalsRepository.findOlderAnimal(age);
		System.out.println(olderAnimal.toString());
		Assertions.assertEquals(1, olderAnimal.size());
	}


	@Test
	@DisplayName("Тест на поиск дубликатов методом findDuplicate")
	public void findDuplicate() {
		System.out.println(animalsRepository.findDuplicate().toString());
		Assertions.assertEquals(1, animalsRepository.findDuplicate().size());

	}

	@Test
	@DisplayName("Тест printDuplicate")
	public void printDuplicate() {
		animalsRepository.printDuplicate();
	}

	@Test
	@DisplayName("Тест findAverageAge()")
	public void findAverageAge() {
		CopyOnWriteArrayList<Animal> list = null;
		Assertions.assertThrows(IllegalListException.class, () -> animalsRepository.findAverageAge(list));
	}

	@Test
	@DisplayName("Тест  findOldAnimalExpensive()")
	public void findOldAnimalExpensive() {
		CopyOnWriteArrayList<Animal> list = null;
		Assertions.assertThrows(IllegalListException.class, () -> animalsRepository.findOldAnimalExpensive(list));
	}

	@Test
	@DisplayName("Тест  findMinConstAnimals()")
	public void findMinConstAnimals() {
		Assertions.assertThrows(IllegalListException.class, () -> animalsRepository.findMinConstAnimals(animalList));
	}

	@Test
	@DisplayName("Тест  findMinConstAnimals()")
	public void findMinConstAnimals2() {
		CopyOnWriteArrayList<Animal> list = null;
		Assertions.assertThrows(IllegalListException.class, () -> animalsRepository.findMinConstAnimals(list));
	}


}
