package edu.epam.car.dao;

import edu.epam.car.entity.Car;
import edu.epam.car.exception.DaoException;

import java.util.List;

public interface BaseDao<K, T extends Car> {

    List<T> findAll() throws DaoException;

    void add(T t) throws DaoException;

    void delete(T t) throws DaoException;

    T updateId(T t, K k) throws DaoException;
}
