package com.company.vehicle;

public class RaceCar extends Vehicle {
    private int topSpeed;

    public RaceCar(String color, String brand) {
        super(color, brand);
        this.topSpeed = 200;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    @Override
    public String toString() {
        return "RaceCar{" +
                "topSpeed" + this.topSpeed +
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
            setSpeed(getSpeed() + 50);
        }
    }

    @Override
    public void brake() {
        if (getSpeed() <= 0) {
            setSpeed(0);
        } else {
            setSpeed(getSpeed() - 30);
        }
    }
}
