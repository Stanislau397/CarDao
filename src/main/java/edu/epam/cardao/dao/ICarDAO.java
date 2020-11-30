package edu.epam.cardao.dao;

import edu.epam.cardao.entity.Car;

import java.util.List;

public interface ICarDAO<K, V, T extends Car> {

    List<T> findAllCarsInShop();
    void createCarFromFile(V t);
    void deleteCar(T t);
    void updateCarId(T t, K k);
}
