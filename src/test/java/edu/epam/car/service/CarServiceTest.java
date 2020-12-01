package edu.epam.car.service;

import edu.epam.car.entity.Brand;
import edu.epam.car.entity.Car;
import edu.epam.car.entity.CarShop;
import edu.epam.car.entity.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CarServiceTest {

    CarService carService;

    @BeforeTest
    public void setUp() {
        this.carService = new CarService();
    }

    @Test
    public void testAddCarToShopTrue() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        Car car2 = new Car(14, Brand.HONDA, "Civic", Color.BLACK, 2015, new BigDecimal(15000));
        carShop.addCar(car1);

        boolean condition = carService.addCarToShop(car2, carShop);

        assertTrue(condition);
    }

    @Test
    public void testAddCarToShopFalse() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        carShop.addCar(car1);

        boolean condition = carService.addCarToShop(car1, carShop);

        assertFalse(condition);
    }

    @Test
    public void testDeleteCarFromShopTrue() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        carShop.addCar(car1);

        boolean condition = carService.deleteCarFromShop(car1, carShop);

        assertTrue(condition);
    }

    @Test
    public void testDeleteCarFromShopFalse() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        Car car2 = new Car(14, Brand.HONDA, "Civic", Color.BLACK, 2015, new BigDecimal(15000));
        carShop.addCar(car1);

        boolean condition = carService.deleteCarFromShop(car2, carShop);

        assertFalse(condition);
    }

    @Test
    public void testFindCarByYear() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        Car car2 = new Car(14, Brand.HONDA, "Civic", Color.BLACK, 2015, new BigDecimal(15000));
        carShop.addCar(car1);
        carShop.addCar(car2);

        int year = 2009;
        List<Car> result = carService.findCarByYear(year, carShop);
        List<Car> expResult = new ArrayList<>();
        expResult.add(car1);

        assertEquals(result, expResult);
    }

    @Test
    public void testFindCarByPrice() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        Car car2 = new Car(14, Brand.HONDA, "Civic", Color.BLACK, 2015, new BigDecimal(15000));
        carShop.addCar(car1);
        carShop.addCar(car2);

        BigDecimal price = new BigDecimal(15000);
        List<Car> result = carService.findCarByPrice(price, carShop);
        List<Car> expResult = new ArrayList<>();
        expResult.add(car1);

        assertEquals(result, expResult);
    }

    @Test
    public void testFindCarByModel() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        Car car2 = new Car(14, Brand.HONDA, "Civic", Color.BLACK, 2015, new BigDecimal(15000));
        carShop.addCar(car1);
        carShop.addCar(car2);

        List<Car> result = carService.findCarByModel("SIX", carShop);
        List<Car> expResult = new ArrayList<>();
        expResult.add(car1);

        assertEquals(result, expResult);
    }

    @Test
    public void testFindAllCarsInShop() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        Car car2 = new Car(14, Brand.HONDA, "Civic", Color.BLACK, 2015, new BigDecimal(15000));
        carShop.addCar(car1);
        carShop.addCar(car2);

        List<Car> result = carService.findAllCarsInShop(carShop);
        List<Car> expResult = new ArrayList<>();
        expResult.add(car1);
        expResult.add(car2);

        assertEquals(result, expResult);
    }

    @Test
    public void testUpdateCarID() {
        Car car = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        long otherId = 15;
        Car result = carService.updateCarID(car, otherId);
        Car expResult = new Car(otherId, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.carService = null;
    }
}