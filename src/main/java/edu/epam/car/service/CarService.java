package edu.epam.car.service;

import edu.epam.car.dao.impl.CarDaoImpl;
import edu.epam.car.entity.Car;
import edu.epam.car.entity.CarShop;

import java.math.BigDecimal;
import java.util.List;

public class CarService {

    private CarDaoImpl carDaoImpl = new CarDaoImpl();

    public boolean addCarToShop(Car car, CarShop carShop) {
        return carDaoImpl.addCarToShop(car, carShop);
    }

    public List<Car> findCarByYear(int year, CarShop carShop) {
        return carDaoImpl.findCarByYear(year, carShop);
    }

    public List<Car> findCarByPrice(BigDecimal price, CarShop carShop) {
        return carDaoImpl.findCarByPrice(price, carShop);
    }

    public List<Car> findCarByModel(String model, CarShop carShop) {
        return carDaoImpl.findCarByModel(model, carShop);
    }

    public List<Car> findAllCarsInShop(CarShop carShop) {
        return carDaoImpl.findAllCarsInShop(carShop);
    }


    public boolean deleteCarFromShop(Car car, CarShop carShop) {
        return carDaoImpl.deleteCarFromShop(car, carShop);
    }

    public Car updateCarID(Car car, Long otherId) {
        return carDaoImpl.updateCarId(car, otherId);
    }
}
