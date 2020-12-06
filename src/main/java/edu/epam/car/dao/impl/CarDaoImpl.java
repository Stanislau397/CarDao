package edu.epam.car.dao.impl;

import edu.epam.car.dao.CarDao;
import edu.epam.car.entity.Car;
import edu.epam.car.entity.CarShop;
import edu.epam.car.exception.DaoException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> findCarByYear(int year) throws DaoException {
        List<Car> cars = CarShop.getInstance().getCars();
        List<Car> carsByYear = new ArrayList<>();

        if (cars.isEmpty()) {
            throw new DaoException();
        }

        for (Car car : cars) {
            if (car.getYear() == year) {
                carsByYear.add(car);
            }
        }
        return carsByYear;
    }

    @Override
    public List<Car> findCarByPrice(BigDecimal price) throws DaoException {
        List<Car> cars = CarShop.getInstance().getCars();
        List<Car> carsByPrice = new ArrayList<>();

        if (cars.isEmpty()) {
            throw new DaoException();
        }

        for (Car car : cars) {
            if (car.getPrice().compareTo(price) < 0) {
                carsByPrice.add(car);
            }
        }
        return carsByPrice;
    }

    @Override
    public List<Car> findCarByModel(String model) throws DaoException {
        List<Car> cars = CarShop.getInstance().getCars();
        List<Car> carsByModel = new ArrayList<>();

        if (cars.isEmpty()) {
            throw new DaoException();
        }

        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                carsByModel.add(car);
            }
        }
        return carsByModel;
    }

    @Override
    public List<Car> findAll() throws DaoException {
        List<Car> cars = CarShop.getInstance().getCars();

        if (cars.isEmpty()) {
            throw new DaoException();
        }
        List<Car> allCars = new ArrayList<>(cars);
        return allCars;
    }

    @Override
    public void add(Car car) throws DaoException {
        CarShop carShop = CarShop.getInstance();

        if (carShop.getCars().contains(car)) {
            throw new DaoException();
        }
        carShop.addCar(car);
    }

    @Override
    public void delete(Car car) throws DaoException {
        CarShop carShop = CarShop.getInstance();

        if (!carShop.getCars().contains(car)) {
            throw new DaoException();
        }
        carShop.removeCar(car);
    }

    @Override
    public Car updateId(Car car, Long otherId) throws DaoException {
        List<Car> carList = CarShop.getInstance().getCars();

        if (!carList.contains(car)) {
            throw new DaoException();
        }
        car.setCarId(otherId);
        return car;
    }
}
