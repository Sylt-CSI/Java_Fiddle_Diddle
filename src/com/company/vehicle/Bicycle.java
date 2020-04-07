package com.company.vehicle;

public class Bicycle implements Vehicle {
    private String color;
    private String brand;
    private int speed = 0;

    public Bicycle(String color, String brand) {
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

    private void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void accelerate() {
        if (this.speed >= 100){
            this.speed = 100;
        } else{
            setSpeed(this.speed += 10);
        }

    }

    @Override
    public void brake() {
        if (this.speed <= 0){
            this.speed = 0;
        } else{
            setSpeed(this.speed -= 10);
        }
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", speed=" + speed +
                '}';
    }
}
