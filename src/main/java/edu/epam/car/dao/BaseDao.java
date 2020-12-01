package edu.epam.car.dao;

import edu.epam.car.entity.Car;
import edu.epam.car.entity.CarShop;

import java.util.List;

public interface BaseDao<K, T extends Car, V extends CarShop> {

    List<T> findAllCarsInShop(V v);

    boolean addCarToShop(T t, V v);

    boolean deleteCarFromShop(T t, V v);

    T updateCarId(T t, K k);
}
