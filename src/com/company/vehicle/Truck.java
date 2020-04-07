package com.company.vehicle;

public class Truck implements Vehicle {
    private String color;
    private String brand;
    private int speed = 0;
    private int carryingCapacity = 0;

    public Truck(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }

    public Truck(String color, String brand, int carryingCapacity) {
        this.color = color;
        this.brand = brand;
        this.carryingCapacity = carryingCapacity;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void accelerate() {
        if (this.speed >= 80) {
            this.speed = 80;
        } else {
            setSpeed(this.speed += 4);
        }

    }

    @Override
    public void brake() {
        if (this.speed <= 0) {
            this.speed = 0;
        } else {
            setSpeed(this.speed -= 6);
        }
    }

    @Override
    public String toString() {
        return "Truck{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", speed=" + speed +
                ", carryingCapacity=" + carryingCapacity +
                '}';
    }
}
