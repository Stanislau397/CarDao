package edu.epam.cardao.entity;

import java.util.ArrayList;
import java.util.List;

public class CarShop {

    private static CarShop instance;
    private List<Car> cars;

    private CarShop() {
        this.cars = new ArrayList<>();
    }

    public static CarShop getInstance() {
        if (instance == null) {
            instance = new CarShop();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getCars() {
        List<Car> carList = new ArrayList<>(cars);
        return carList;
    }
}
