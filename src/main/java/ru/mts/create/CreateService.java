package ru.mts.create;

import ru.mts.animals.Animal;

/**
 * The interface Create service.
 */
public interface CreateService {
    /**
     * ������� ������ �� n ��������� ��������
     *
     * @param n    ���������� �������� � �������
     * @param type the type
     * @return ������ ��������
     */
    Animal[] createAnimals(int n, AnimalTypes type);
}
