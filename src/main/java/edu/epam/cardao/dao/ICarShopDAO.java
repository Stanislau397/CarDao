package edu.epam.cardao.dao;

import edu.epam.cardao.entity.Car;

import java.math.BigDecimal;
import java.util.List;

public interface ICarShopDAO extends ICarDAO<Long, String, Car> {

    void addCarToCarShop(Car car);
    List<Car> findCarByYear(int year);
    List<Car> findCarByPrice(BigDecimal price);
    List<Car> findCarByModel(String model);
}
