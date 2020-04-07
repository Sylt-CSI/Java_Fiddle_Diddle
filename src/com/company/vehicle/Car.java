package com.company.vehicle;

public class Car extends Vehicle {

    public Car(String color, String brand) {
        super(color, brand);
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + getSpeed() +
                ", color='" + getColor() + '\'' +
                ", brand='" + getBrand() + '\'' +
                '}';
    }

    @Override
    public void accelerate() {
        if (getSpeed() >= 100) {
            setSpeed(100);
        } else {
            setSpeed(getSpeed() + 10);
        }
    }

    @Override
    public void brake() {
        if (getSpeed() <= 0) {
            setSpeed(0);
        } else {
            setSpeed(getSpeed() - 10);
        }
    }
}
