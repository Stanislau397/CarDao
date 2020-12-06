package edu.epam.car.util;

import edu.epam.car.entity.Brand;
import edu.epam.car.entity.Car;
import edu.epam.car.entity.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FileScannerTest {

    FileScanner fileScanner;
    static final String PATH = "file";

    @BeforeTest
    public void setUp() {
        this.fileScanner = new FileScanner();
    }

    @Test
    public void testReadCarsFromFile() {
        List<Car> result = fileScanner.readCarsFromFile(PATH);
        List<Car> expResult = new ArrayList<>();
        expResult.add(new Car(15632, Brand.BMW, "X5", Color.WHITE, 2018, new BigDecimal("20000.0")));
        expResult.add(new Car(2123, Brand.MAZDA, "Six", Color.GREY, 2019, new BigDecimal("15000.0")));
        expResult.add(new Car(3098, Brand.HONDA, "Civic", Color.BLACK, 2009, new BigDecimal("5000.0")));
        expResult.add(new Car(4435, Brand.AUDI, "A6", Color.BLACK, 2015, new BigDecimal("15000.0")));
        expResult.add(new Car(5765, Brand.TESLA, "ModelX", Color.WHITE, 2018, new BigDecimal("60000.0")));
        expResult.add(new Car(68772, Brand.FORD, "Mustang", Color.BLACK, 2019, new BigDecimal("35000.0")));
        expResult.add(new Car(7123, Brand.AUDI, "A8", Color.RED, 2020, new BigDecimal("75000.0")));
        expResult.add(new Car(8145, Brand.KIA, "Rio", Color.WHITE, 2019, new BigDecimal("35000.0")));
        expResult.add(new Car(9654, Brand.BMW, "M5", Color.GREY, 2015, new BigDecimal("65000.0")));
        expResult.add(new Car(10111, Brand.MERCEDES, "M", Color.BLACK, 2018, new BigDecimal("95000.0")));

        assertEquals(result, expResult);
    }

    @AfterTest
    public void tierDown() {
        this.fileScanner = null;
    }
}