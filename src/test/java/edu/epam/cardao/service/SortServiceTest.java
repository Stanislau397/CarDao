package edu.epam.cardao.service;

import edu.epam.cardao.entity.Brand;
import edu.epam.cardao.entity.Car;
import edu.epam.cardao.entity.CarShop;
import edu.epam.cardao.entity.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SortServiceTest {

    SortService sortService;

    @BeforeTest
    public void setUp() {
        this.sortService = new SortService();
    }

    @Test
    public void testSortCarsByModel() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        Car car2 = new Car(14, Brand.HONDA, "Civic", Color.BLACK, 2015, new BigDecimal(15000));
        carShop.addCar(car1);
        carShop.addCar(car2);

        List<Car> result = sortService.sortCarsByModel(carShop);
        List<Car> expResult = new ArrayList<>();
        expResult.add(car2);
        expResult.add(car1);

        assertEquals(result, expResult);
    }

    @Test
    public void testSortCarsByYear() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        Car car2 = new Car(14, Brand.HONDA, "Civic", Color.BLACK, 2015, new BigDecimal(15000));
        carShop.addCar(car2);
        carShop.addCar(car1);

        List<Car> result = sortService.sortCarsByYear(carShop);
        List<Car> expResult = new ArrayList<>();
        expResult.add(car1);
        expResult.add(car2);

        assertEquals(result, expResult);
    }

    @Test
    public void testSortCarsByPrice() {
        CarShop carShop = CarShop.getInstance();
        Car car1 = new Car(12, Brand.MAZDA, "SIX", Color.WHITE, 2009, new BigDecimal(6000));
        Car car2 = new Car(14, Brand.HONDA, "Civic", Color.BLACK, 2015, new BigDecimal(15000));
        carShop.addCar(car2);
        carShop.addCar(car1);

        List<Car> result = sortService.sortCarsByPrice(carShop);
        List<Car> expResult = new ArrayList<>();
        expResult.add(car1);
        expResult.add(car2);

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.sortService = null;
    }
}