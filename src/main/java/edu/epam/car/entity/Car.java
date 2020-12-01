package edu.epam.car.entity;

import java.math.BigDecimal;

public class Car {

    private long carId;
    private Brand brand;
    private String model;
    private Color color;
    private int year;
    private BigDecimal price;

    public Car() {

    }

    public Car(long carId, Brand brand, String model, Color color, int year, BigDecimal price) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getCarId() {
        return carId;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (carId != car.carId) return false;
        if (year != car.year) return false;
        if (brand != car.brand) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (color != car.color) return false;
        return price != null ? price.equals(car.price) : car.price == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (carId ^ (carId >>> 32));
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brand: ").append(brand).append(" Model: ").append(model)
                .append(" Color: ").append(color).append(" CarId: ").append(carId)
                .append(" releaseYear: ").append(year).append(" Price: ").append(price);
        return sb.toString();
    }
}
