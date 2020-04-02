package com.company;

import java.util.Date;
import java.util.Scanner;

public class Lecture1 {
    //        Assignment1();
//        Assignment2();
//        Assignment3();
//        Assignment4();
//        Assignment5();
//        Assignment6();
//        Assignment7();
//        Assignment8();
//        Assignment9(1,2);
//        Assignment9_1("soep");


    private static void assignment9_1(String tekst) {
        System.out.println(new Date() + " - Main - " + tekst);
    }

    private static void assignment9(int number1, int number2) {
        System.out.println(number1 + number2);
    }

    private static void Assignment8() {
        System.out.print("Voor een zin in: ");
        Scanner requestMessage = new Scanner(System.in);
        String message = requestMessage.nextLine();
        String [] splittedMessage = message.split(" ");
        System.out.println("Aantal karakters in de zin: "+ message.length() + "\nAantal woorden: "+ splittedMessage.length);
    }

    private static void assignment7() {
        int[] lijst = {1,2,3,4,5,6,7,8,9,10};

        int total = 0;

        for (int number: lijst
        ) {
            total += number;
            System.out.println(number);
        }
        System.out.println("Total: " + total + " Average: " + (total/lijst.length));

        for (int i = 0; i < lijst.length ; i++){
            System.out.println(lijst[lijst.length-(i+1)]);
        }
    }

    private static void assignment6() {
//        diagonal = ==
//        lower left corner = <=
//        top right corner = >=
//        top left corner is a single for loop?


        for (int i = 0; i < 4;i++){
            System.out.println();
            for (int j = 0; j < 4; j++){
//                System.out.print(" * ");
                if (i <= j){
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
        }
    }

    private static void assignment5() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Typ hier het eerste nummer: ");
        int firstNumber = Integer.parseInt(inputScanner.nextLine());
        System.out.print("Typ hier het tweede nummer: ");
        int secondNumber = Integer.parseInt(inputScanner.nextLine());
        System.out.print("Typ hier de operator: ");
        String stringOperator = inputScanner.nextLine();
        switch (stringOperator) {
            case "+":
                System.out.println(firstNumber + secondNumber);
                break;
            case "-":
                System.out.println(firstNumber - secondNumber);
                break;
            case "*":
                System.out.println(firstNumber * secondNumber);
                break;
            case "/":
                System.out.println(firstNumber / secondNumber);
                break;
            default:
                System.out.println("Sorry I am not a clever calculator, you might need to try me at a new version.");
                break;
        }

    }

    private static void assignment4() {
        Scanner messageRequest = new Scanner(System.in);
        System.out.println("Menu keuzes om berichten te printen\n" +
                "1 || hoi\n" +
                "2 || doei\n" +
                "(!1 || !2) == I don't get it.");
        String stringMessage = messageRequest.nextLine();
        if (stringMessage.equals("Hoi") || stringMessage.equals("1")){
            System.out.println("Eeejo!");
        } else if (stringMessage.equals("doei") || stringMessage.equals("2")){
            System.out.println("Baiiii");
        } else {
            System.out.println("I don't get it :(.");
        }

    }

    private static void assignment3(){
        Scanner numberRequest = new Scanner(System.in);
        System.out.print("The first number for addition: ");
        int firstNumber = numberRequest.nextInt();
        System.out.print("The second number for addition: ");
        int secondNumber = numberRequest.nextInt();
        System.out.println(firstNumber + secondNumber);
    }

    private static void assignment2(){
        Scanner nameRequest = new Scanner(System.in);
        System.out.println("What is thy name?");
        String name = nameRequest.nextLine();
        System.out.println("Greetings " + name);
    }

    private static void assignment1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("read: ");
        String s = scanner.nextLine();
        System.out.println("write: "+ s);
    }
}
