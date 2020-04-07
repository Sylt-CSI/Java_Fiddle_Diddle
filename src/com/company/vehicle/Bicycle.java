package com.company.vehicle;

public class Bicycle extends Vehicle {

    public Bicycle(String color, String brand) {
        super(color, brand);
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "speed=" + getSpeed() +
                ", color='" + getColor() + '\'' +
                ", brand='" + getBrand() + '\'' +
                '}';
    }

    @Override
    public void accelerate() {
        if (getSpeed() >= 10) {
            setSpeed(10);
        } else {
            setSpeed(getSpeed() + 1);
        }
    }

    @Override
    public void brake() {
        if (getSpeed() <= 0) {
            setSpeed(0);
        } else {
            setSpeed(getSpeed() - 1);
        }
    }
}
//    private String brand;
//    private int speed = 0;
//
//    public Bicycle(String color, String brand) {
//        this.color = color;
//        this.brand = brand;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public int getSpeed() {
//        return speed;
//    }
//
//    private void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
//    @Override
//    public void accelerate() {
//        if (this.speed >= 100){
//            this.speed = 100;
//        } else{
//            setSpeed(this.speed += 10);
//        }
//
//    }
//
//    @Override
//    public void brake() {
//        if (this.speed <= 0){
//            this.speed = 0;
//        } else{
//            setSpeed(this.speed -= 10);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Bicycle{" +
//                "color='" + color + '\'' +
//                ", brand='" + brand + '\'' +
//                ", speed=" + speed +
//                '}';
//    }
