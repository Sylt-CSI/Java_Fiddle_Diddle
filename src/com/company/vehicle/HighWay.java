package com.company.vehicle;

public class HighWay {
    public static void main(String[] args) {
        Car myCar = new Car("Red","Tesla");
        for (int timeSteps = 0; timeSteps < 10; timeSteps++) {
            myCar.accelerate();
            System.out.println(myCar.toString());
        }
        System.out.println(myCar.toString());
        System.out.println(myCar.getSpeed());
        myCar.brake();
        System.out.println(myCar.getSpeed());
        Car mySuzuki = new Car("Gray","Suzuki");
        for (int gas = 0; gas < 3; gas++) {
            mySuzuki.accelerate();
        }
        System.out.println(mySuzuki.getSpeed());
        System.out.println(mySuzuki.toString());
        Truck truck1 = new Truck("Blue","Volvo",1000);
        System.out.println(truck1.toString());
        RaceCar mySecondCar = new RaceCar("Red","Ferrari");
        System.out.println(mySecondCar.toString());
        Bicycle myBicycle = new Bicycle("Gray","vanMook");
        System.out.println(myBicycle);

    }
}
