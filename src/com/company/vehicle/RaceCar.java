package com.company.vehicle;

public class RaceCar implements Vehicle {
    private String color;
    private String brand;
    private int speed = 0;
    private int topSpeed = 200;

    public RaceCar(String color, String brand) {
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

    public int getTopSpeed() {
        return topSpeed;
    }

    @Override
    public void accelerate() {
        if (this.speed >= topSpeed) {
            this.speed = topSpeed;
        } else {
            setSpeed(this.speed += 50);
        }

    }

    @Override
    public void brake() {
        if (this.speed <= 0) {
            this.speed = 0;
        } else {
            setSpeed(this.speed -= 30);
        }
    }

    @Override
    public String toString() {
        return "RaceCar{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", speed=" + speed +
                ", topSpeed=" + topSpeed +
                '}';
    }
}
