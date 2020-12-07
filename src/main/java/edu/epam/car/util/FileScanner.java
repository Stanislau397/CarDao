package edu.epam.car.util;

import edu.epam.car.entity.Brand;
import edu.epam.car.entity.Car;
import edu.epam.car.entity.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileScanner {

    public static final Logger logger = LogManager.getLogger(FileScanner.class);

    public List<Car> readCarsFromFile(String path) {
        List<Car> cars = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(path))) {

            while (scanner.hasNext()) {
                Car car = new Car();

                car.setCarId(scanner.nextLong());
                car.setBrand(Brand.valueOf(scanner.next()));
                car.setModel(scanner.next());
                car.setColor(Color.valueOf(scanner.next()));
                car.setYear(scanner.nextInt());
                car.setPrice(scanner.nextBigDecimal());

                cars.add(car);
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        return cars;
    }
}
