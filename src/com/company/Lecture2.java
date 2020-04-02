package com.company;

import java.util.*;

public class Lecture2 {

    //    1,2,3,5,6,8
//    9,11,14,15,16
//    19,21,22,23,25,27
    public Lecture2() {
        assignment27();
//        assignment25();
//        assignment23();
//        assignment22();
//        assignment19();
    }

    private void assignment27() {
        Random random = new Random();
        int[] randomScoreArray = random.ints(20, 0, 100).toArray();
        System.out.println(Arrays.toString(randomScoreArray));
        for (int i = 0; i < randomScoreArray.length; i++) {
            if (randomScoreArray[i] > 85 && randomScoreArray[i] < 90) {
                System.out.println("Participant " + i + " has a score of " + randomScoreArray[i]);
            }
        }
    }

    private void assignment25() {
        Scanner commandLineInput = new Scanner(System.in);
        double[] lowestHighestTemps = new double[2];
        System.out.println("Highest temperature this year?");
        lowestHighestTemps[1] = Double.parseDouble(commandLineInput.nextLine());
        System.out.println("Lowest temperature this year?");
        lowestHighestTemps[0] = Double.parseDouble(commandLineInput.nextLine());
        System.out.println(Arrays.toString(lowestHighestTemps));
    }

    private void assignment23() {
        String[] names = {"Lazy", "Crazy"}; //etc.
        String[] bDays = {"1988-09-29", "1970-01-01"}; //etc
        String[] pNumbers = {"0612345678", "0612345679"}; //etc.

        Scanner commandLine = new Scanner(System.in);
        System.out.println("Give a name to get the rest of the info.");
        String inputCommandLine = commandLine.nextLine();
        int found = -1;
        for (int i = 0; i < names.length; i++) {
            if (inputCommandLine.equals(names[i])) {
                found = i;
                break;
            }
        }
        if (found != -1) {
            System.out.println(bDays[found] + " " + pNumbers[found]);
        } else {
            System.out.println("Don't know that name.");
        }
    }

    private void assignment22() {
        ArrayList<Integer> primes = new ArrayList<Integer>();

        primes.add(1);
        primes.add(2);
        for (int numberInChain = 2; numberInChain < 40; numberInChain++) {
            for (int testNumber = 2; testNumber < numberInChain; testNumber++) {
                if (numberInChain % testNumber == 0) {
                    break;
                } else if (numberInChain - 1 == testNumber) {
                    primes.add(numberInChain);
                }
            }

        }
        System.out.println(primes);

//        primes.add();
    }

    private void assignment21() {
        int total = 0;
        Scanner commandlineScanner = new Scanner(System.in);
        System.out.println("Fill in a bunch of numbers");
        String inputString = commandlineScanner.nextLine();
        String[] stringElements = inputString.split("");
        for (String stringElement : stringElements) {
            try {
                total += Integer.parseInt(stringElement);
            } catch (Exception e) {
                System.out.println("not a number");
            }

        }
        System.out.println(total);
    }

    private void assignment19() {
        int count = 0;
        Scanner commandlineScanner = new Scanner(System.in);
        System.out.println("Give a word to find all a and A characters in their.");
        String givenWord = commandlineScanner.nextLine();
        for (int i = 0; i < givenWord.length(); i++) {
            if (givenWord.substring(i, i + 1).equals("A") || givenWord.substring(i, i + 1).equals("a")) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void assignment16() {
        for (int i = 5; i < 45; i += 4) {
            System.out.printf(" %s ", i);
        }
    }

    public static void assignment15() {
        int sum = 0;
        for (int i = 2; i < 20; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void assignment14() {
        int sum = 0;
        for (int i = 2; i < 20; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void assignment11() {
        Scanner commandLineScanner = new Scanner(System.in);
        double costCount = 0;
        HashMap<Integer, Double> productPriceMap = new HashMap<Integer, Double>() {
            {
                put(1, 2.95);
                put(2, 4.99);
                put(3, 5.49);
                put(4, 7.80);
                put(5, 8.85);
            }
        };
        for (int i = 0; i < productPriceMap.size(); i++) {
            System.out.printf("How many did you get of product %s?\n", i + 1);
            costCount += productPriceMap.get(i + 1) * Integer.parseInt(commandLineScanner.nextLine());
        }
        System.out.println(costCount);

    }

    public static void assignment9() {
        Scanner inputScanner = new Scanner(System.in);
        int number = Integer.parseInt(inputScanner.nextLine());
        if (number < 1 || number > 10) {
            System.out.println("good");
        } else {
            System.out.println("Not so good");
        }
    }

    public static void assignment8() {
        int highestNumber = Integer.MIN_VALUE;
        int[] numberCollection = new int[3];
        Scanner numberLineScanner = new Scanner(System.in);
        System.out.println("Fill in the first number.");
        numberCollection[0] = Integer.parseInt(numberLineScanner.nextLine());
        System.out.println("Fill in the second number.");
        numberCollection[1] = Integer.parseInt(numberLineScanner.nextLine());
        System.out.println("Fill in the third number.");
        numberCollection[2] = Integer.parseInt(numberLineScanner.nextLine());
        for (int number : numberCollection
        ) {
            if (number > highestNumber) {
                highestNumber = number;
            }
        }
        System.out.println(highestNumber);
    }

    public static void assignment6(int numberOfIterations) {
        int score = 0;
        Scanner inputScanner = new Scanner(System.in);
        for (int i = 0; i < numberOfIterations; i++) {
            String inputFromCommandLine = inputScanner.nextLine();
            try {
                int localScoreValue = Integer.parseInt(inputFromCommandLine);
                if (localScoreValue > 10 || localScoreValue < 1) {
                    i--;
                    System.out.println("Out of the range 1 and 10;, try again.");
                }
                if (localScoreValue > 7) {
                    score++;
                }
            } catch (Exception e) {
                i--;
                System.out.println("Not an integer.");
            }
        }
        System.out.println("Number of numbers greater than 7:" + score);
    }

    public static void assignment5(int x, int y, String operator) {
        if (y == 5 && operator.equals("/")) {
            x = 100;
        } else if (y == 5 && operator.equals("*")) {
            x = 1;
        } else if (x < y) {
            x = x * x;
        } else if (x > y) {
            x = x + 1;
        }

    }

    public static void assignment3(double side1, double side2) {
        System.out.println(Math.pow(Math.pow(side1, 2) + Math.pow(side2, 2), 0.5));
    }

    public static void assignment2(double degreesCelsius) {
        System.out.println(degreesCelsius * 1.8 + 32);
    }

    public static void assignment1(String article, String noun, String verb) {
        if (article.equals("The") || article.equals("An")) {
            System.out.println(article + " " + noun + " " + verb);
        } else {
            System.out.println("It seems you have not used an article to start the sentence.");
        }

    }


}
