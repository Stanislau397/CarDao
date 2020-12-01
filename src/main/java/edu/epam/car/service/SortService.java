package edu.epam.car.service;

import edu.epam.car.entity.Car;
import edu.epam.car.entity.CarShop;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortService {

    public List<Car> sortCarsByModel(CarShop carShop) {
        List<Car> sortedCarsByModel = carShop.getCars();

        return sortedCarsByModel.stream()
                .sorted(Comparator.comparing(Car::getModel))
                .collect(Collectors.toList());
    }

    public List<Car> sortCarsByYear(CarShop carShop) {
        List<Car> sortedCarsByYear = carShop.getCars();

        return sortedCarsByYear.stream()
                .sorted(Comparator.comparing(Car::getYear))
                .collect(Collectors.toList());
    }

    public List<Car> sortCarsByPrice(CarShop carShop) {
        List<Car> sortedCarsByPrice = carShop.getCars();

        return sortedCarsByPrice.stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .collect(Collectors.toList());
    }
}
