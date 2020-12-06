package edu.epam.car.service.impl;

import edu.epam.car.dao.CarDao;
import edu.epam.car.dao.impl.CarDaoImpl;
import edu.epam.car.entity.Car;
import edu.epam.car.exception.DaoException;
import edu.epam.car.service.CarService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

    private static final Logger logger = LogManager.getLogger(CarServiceImpl.class);
    private CarDao carDao;

    public CarServiceImpl() {
        this.carDao = new CarDaoImpl();
    }

    @Override
    public void addCar(Car car) {
        try {
            carDao.add(car);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    @Override
    public void removeCar(Car car) {
        try {
            carDao.delete(car);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    @Override
    public List<Car> findAllCars() {
        List<Car> allCars = new ArrayList<>();

        try {
            allCars = carDao.findAll();
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        return allCars;
    }

    @Override
    public Car updateCarId(Car car, Long otherId) {
        Car carWithNewId = new Car();

        try {
            carWithNewId = carDao.updateId(car, otherId);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        return carWithNewId;
    }

    @Override
    public List<Car> findCarByYear(int year) {
        List<Car> carsByYear = new ArrayList<>();

        try {
            carsByYear = carDao.findCarByYear(year);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        return carsByYear;
    }

    @Override
    public List<Car> findCarByModel(String model) {
        List<Car> carsByModel = new ArrayList<>();

        try {
            carsByModel = carDao.findCarByModel(model);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        return carsByModel;
    }

    @Override
    public List<Car> findCarByPrice(BigDecimal price) {
        List<Car> carsByPrice = new ArrayList<>();

        try {
            carsByPrice = carDao.findCarByPrice(price);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
        return carsByPrice;
    }
}
