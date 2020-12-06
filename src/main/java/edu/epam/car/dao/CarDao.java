package edu.epam.car.dao;

import edu.epam.car.entity.Car;
import edu.epam.car.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface CarDao extends BaseDao<Long, Car> {

    List<Car> findCarByYear(int year) throws DaoException;

    List<Car> findCarByPrice(BigDecimal price) throws DaoException;

    List<Car> findCarByModel(String model) throws DaoException;
}
