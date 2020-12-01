package edu.epam.car.dao.impl;

import edu.epam.car.dao.CarDao;
import edu.epam.car.entity.Car;
import edu.epam.car.entity.CarShop;
import edu.epam.car.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CarDaoImpl implements CarDao {

    private static final Logger logger = LogManager.getLogger(CarDaoImpl.class);

    @Override
    public boolean addCarToShop(Car car, CarShop carShop) {
        if (carShop.getCars().contains(car)) {
            logger.throwing(new DaoException());
            return false;
        }
        carShop.addCar(car);
        return true;
    }

    @Override
    public boolean deleteCarFromShop(Car car, CarShop carShop) {
        if (!carShop.getCars().contains(car)) {
            logger.throwing(new DaoException());
            return false;
        }
        carShop.removeCar(car);
        return true;
    }

    @Override
    public List<Car> findCarByYear(int year, CarShop carShop) {
        List<Car> carsByYear = carShop.getCars();

        return carsByYear.stream()
                .filter(carYear -> carYear.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findCarByPrice(BigDecimal price, CarShop carShop) {
        List<Car> carsByPrice = carShop.getCars();

        return carsByPrice.stream()
                .filter(carPrice -> carPrice.getPrice().compareTo(price) < 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findCarByModel(String model, CarShop carShop) {
        List<Car> carsByModel = carShop.getCars();

        return carsByModel.stream()
                .filter(carModel -> carModel.getModel().equals(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findAllCarsInShop(CarShop carShop) {
        List<Car> allCars = carShop.getCars();
        return allCars;
    }

    @Override
    public Car updateCarId(Car car, Long otherId) {
        car.setCarId(otherId);
        return car;
    }
}
