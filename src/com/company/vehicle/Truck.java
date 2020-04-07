package com.company.vehicle;

public class Truck extends Vehicle {
    private int loadingCapacity;

    public Truck(String color, String brand, int loadingCapacity) {
        super(color, brand);
        this.loadingCapacity = loadingCapacity;
    }

    public int getLoadingCapacity() {
        return loadingCapacity;
    }

    @Override
    public String toString() {
        return "RaceCar{" +
                "topSpeed" + loadingCapacity +
                "speed=" + getSpeed() +
                ", color='" + getColor() + '\'' +
                ", brand='" + getBrand() + '\'' +
                '}';
    }

    @Override
    public void accelerate() {
        if (getSpeed() >= 80) {
            setSpeed(80);
        } else {
            setSpeed(getSpeed() + 4);
        }
    }

    @Override
    public void brake() {
        if (getSpeed() <= 0) {
            setSpeed(0);
        } else {
            setSpeed(getSpeed() - 6);
        }
    }
}
