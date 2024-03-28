package ru.mts.create;

import ru.mts.entity.Animal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The interface Create service.
 */
public interface CreateService {

    Map<String, List<Animal>> createAnimals();
}
