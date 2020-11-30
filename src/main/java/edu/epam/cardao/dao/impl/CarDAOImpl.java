package edu.epam.cardao.dao.impl;

import edu.epam.cardao.dao.ICarShopDAO;
import edu.epam.cardao.entity.Brand;
import edu.epam.cardao.entity.Car;
import edu.epam.cardao.entity.CarShop;
import edu.epam.cardao.entity.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarDAOImpl implements ICarShopDAO {

    private static final Logger logger = LogManager.getLogger(CarDAOImpl.class);

    @Override
    public void addCarToCarShop(Car car) {
        CarShop carShop = CarShop.getInstance();

        if (carShop.getCars().contains(car)) {
            logger.throwing(new IllegalArgumentException());
        }
        carShop.addCar(car);
    }

    @Override
    public void createCarFromFile(String path) {
        CarShop carShop = CarShop.getInstance();

        try (Scanner scanner = new Scanner(new FileReader(path))) {

            while (scanner.hasNext()) {
                Car car = new Car();
                car.setCarId(scanner.nextLong());
                car.setBrand(Brand.valueOf(scanner.next()));
                car.setModel(scanner.next());
                car.setColor(Color.valueOf(scanner.next()));
                car.setYear(scanner.nextInt());
                car.setPrice(scanner.nextBigDecimal());
                carShop.addCar(car);
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void deleteCar(Car car) {
        CarShop carShop = CarShop.getInstance();

        if (!carShop.getCars().contains(car)) {
            logger.throwing(new NoSuchElementException());
        }
        carShop.removeCar(car);
    }

    @Override
    public void updateCarId(Car car, Long otherId) {

    }

    @Override
    public List<Car> findCarByYear(int year) {
        CarShop carShop = CarShop.getInstance();
        List<Car> carsByYear = carShop.getCars();

        return carsByYear.stream()
                .filter(carYear -> carYear.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findCarByPrice(BigDecimal price) {
        CarShop carShop = CarShop.getInstance();
        List<Car> carsByPrice = carShop.getCars();

        return carsByPrice.stream()
                .filter(carPrice -> carPrice.getPrice().equals(price))
                .collect(Collectors.toList());

    }

    @Override
    public List<Car> findCarByModel(String model) {
        CarShop carShop = CarShop.getInstance();
        List<Car> carsByModel = carShop.getCars();

        return carsByModel.stream()
                .filter(carModel -> carModel.getModel().equals(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findAllCarsInShop() {
        CarShop carShop = CarShop.getInstance();
        List<Car> allCars = carShop.getCars();

        return allCars;
    }
}
