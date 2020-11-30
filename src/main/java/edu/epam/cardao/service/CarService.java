package edu.epam.cardao.service;

import edu.epam.cardao.dao.impl.CarDAOImpl;
import edu.epam.cardao.entity.Car;

import java.math.BigDecimal;
import java.util.List;

public class CarService {

    public void addCarToCarShop(Car car) {
        new CarDAOImpl().addCarToCarShop(car);
    }

    public List<Car> findCarByYear(int year) {
        return new CarDAOImpl().findCarByYear(year);
    }

    public List<Car> findCarByPrice(BigDecimal price) {
        return new CarDAOImpl().findCarByPrice(price);
    }

    public List<Car> findCarByModel(String model) {
        return new CarDAOImpl().findCarByModel(model);
    }

    public List<Car> findAllCarsInShop() {
        return new CarDAOImpl().findAllCarsInShop();
    }

    public void createCarFromFile(String car) {
        new CarDAOImpl().createCarFromFile(car);
    }

    public void deleteCar(Car car) {
        new CarDAOImpl().deleteCar(car);
    }

    public void updateCar(Car car, Long carId) {
        new CarDAOImpl().updateCarId(car, carId);
    }
}
