package edu.epam.car.service;

import edu.epam.car.entity.Car;

import java.math.BigDecimal;
import java.util.List;

public interface CarService {

    void addCar(Car car);

    void removeCar(Car car);

    List<Car> findAllCars();

    Car updateCarId(Car car, Long otherId);

    List<Car> findCarByYear(int year);

    List<Car> findCarByModel(String model);

    List<Car> findCarByPrice(BigDecimal price);
}
