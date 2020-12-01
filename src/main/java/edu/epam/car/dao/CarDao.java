package edu.epam.car.dao;

import edu.epam.car.entity.Car;
import edu.epam.car.entity.CarShop;

import java.math.BigDecimal;
import java.util.List;

public interface CarDao extends BaseDao<Long, Car, CarShop> {

    List<Car> findCarByYear(int year, CarShop carShop);

    List<Car> findCarByPrice(BigDecimal price, CarShop carShop);

    List<Car> findCarByModel(String model, CarShop carShop);
}
