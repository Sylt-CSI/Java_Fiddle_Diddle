package com.company.vehicle;

abstract class Vehicle {
    private String color;
    private String brand;
    private int speed = 0;

    public Vehicle(String color, String brand) {
        this.color = color;
        this.brand = brand;
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void accelerate();

    public abstract void brake();
}
