package com.company.numberguesser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuesser implements ActionListener {
    boolean gameStarted = false;
    boolean restart = false;
    JFrame newFrame = new JFrame();
    JLabel displayLabel = new JLabel("Lives remaining: ");
    JButton buttonLabel = new JButton("Start");
    HashMap<Integer, JTextField> jTextFieldElements = new HashMap<Integer, JTextField>();
    HashMap<Integer, JLabel> jLabelElements = new HashMap<Integer, JLabel>();

    int theSuperSecretNumber;
    int sessionLives;

    public NumberGuesser() {
        JPanel numberGuesserPanelLayout = new JPanel();
        numberGuesserPanelLayout.setLayout(new GridLayout(6, 2));
        drawGameLayout(numberGuesserPanelLayout);
        // Define display label and position.
        newFrame.getContentPane().add(displayLabel, BorderLayout.NORTH);
        newFrame.getContentPane().add(numberGuesserPanelLayout, BorderLayout.CENTER);

        // Final step.
        deployFrame(newFrame);
    }

    private void drawGameLayout(JPanel numberGuesserPanelLayout) {
        String[] textLabels = {"Total attempts (default = 5)", "Your guess", "", "", "Start guess range (default = 0)", "Result:", "", "", "Stop guess range (default = 10)", "", ""};
        /*
        2 Total attempts
        3 Your guess
        6 Start guess range
        7 *Result label
        10 Stop guess range
         */
        for (int i = 0; i < textLabels.length; i++) {
            if (i == 2 || i == 3 || i == 6 || i == 10) {
                JTextField textField = new JTextField(textLabels[i]);
                numberGuesserPanelLayout.add(textField);
                jTextFieldElements.put(i, textField);
            } else {
                JLabel label = new JLabel(textLabels[i]);
                numberGuesserPanelLayout.add(label);
                jLabelElements.put(i, label);
            }
        }
        numberGuesserPanelLayout.add(buttonLabel);
        buttonLabel.addActionListener(this);

    }

    private void deployFrame(JFrame newFrame) {
        newFrame.setSize(400, 400);
        newFrame.setVisible(true);
        newFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        boolean activeAttempt = true;
        System.out.println(buttonLabel.getText());

        if (buttonLabel.getText().equals("Retry")) {
            jLabelElements.get(7).setText("");
            jTextFieldElements.get(2).setEditable(true);
            jTextFieldElements.get(6).setEditable(true);
            jTextFieldElements.get(10).setEditable(true);
            jTextFieldElements.get(2).setText("");
            jTextFieldElements.get(6).setText("");
            jTextFieldElements.get(10).setText("");
            buttonLabel.setText("Start");
            gameStarted = false;
        }
        if ("".equals(jTextFieldElements.get(3).getText())) {
            // Is input given?
            jLabelElements.get(7).setText("Fill something in for a guess.");
            activeAttempt = false;
        }

        if (restart) {
            activeAttempt = false;
            restart = false;
        }

        if (!gameStarted && activeAttempt) {
            startGame();
            gameStarted = true;
        }

        if (activeAttempt) {
            System.out.println(theSuperSecretNumber + " " + sessionLives);
            if (validateGameAnswer()) {
                buttonLabel.setText("Retry");
            } else if (!validateGameAnswer() && sessionLives <= 1) {
                buttonLabel.setText("Retry");
                jLabelElements.get(7).setText("You have no attempts left.");
                sessionLives = Integer.MAX_VALUE;
                restart = true;
            } else if (!validateGameAnswer()) {
                buttonLabel.setText("Guess");
                sessionLives--;
            }
        } else {
            System.out.println("Not a real attempt.");
        }
        jTextFieldElements.get(3).setText("");
        displayLabel.setText("Lives remaining: "+sessionLives);
    }

    private boolean validateGameAnswer() {
        int userInput = validateGameInitializerCharacterInput();
        boolean correctAnswerState;
        if (theSuperSecretNumber == userInput) {
            jLabelElements.get(7).setText("You guessed correctly, it was " + theSuperSecretNumber);
            correctAnswerState = true;
        } else if (userInput == -1) {
            jLabelElements.get(7).setText("Invalid input, you lost a live.");
            correctAnswerState = false;
        } else if (theSuperSecretNumber > userInput) {
            jLabelElements.get(7).setText("Guess higher.");
            correctAnswerState = false;
        } else {
            jLabelElements.get(7).setText("Guess lower.");
            correctAnswerState = false;
        }
        return correctAnswerState;
    }

    private void startGame() {
        theSuperSecretNumber = generateRandomNumberBasedOnInputs(
                jTextFieldElements.get(2).getText(),
                jTextFieldElements.get(6).getText(),
                jTextFieldElements.get(10).getText());
        // Close modificaton
        jTextFieldElements.get(2).setEditable(false);
        jTextFieldElements.get(6).setEditable(false);
        jTextFieldElements.get(10).setEditable(false);
    }

    private int generateRandomNumberBasedOnInputs(String numberOfAttempts, String startingNumber, String endingNumber) {
        String[] inputRange = {numberOfAttempts, startingNumber, endingNumber};
        int[] pureNumbers = validateGameInitializerCharacterInput(inputRange);
        // Yugh.
        sessionLives = pureNumbers[0];
        return ThreadLocalRandom.current().nextInt(pureNumbers[1], pureNumbers[2] + 1);
    }

    private int validateGameInitializerCharacterInput() {
        int userAnswer;
        try {
            userAnswer = Integer.parseInt(jTextFieldElements.get(3).getText());
        } catch (Exception e) {
            userAnswer = -1;
        }
        return userAnswer;
    }

    private int[] validateGameInitializerCharacterInput(String[] inputRange) {
        int[] pureNumbers = new int[inputRange.length];
        for (int i = 0; i < inputRange.length; i++) {
            try {
                pureNumbers[i] = Integer.parseInt(inputRange[i]);
            } catch (Exception e) {
                pureNumbers[i] = 0;
            }
        }
        return validateNumberRange(pureNumbers);
    }

    private int[] validateNumberRange(int[] pureNumbers) {
        for (int index = 0; index < pureNumbers.length; index++) {
            if (pureNumbers[index] <= 0) {
                pureNumbers[index] = 0;
            }
        }
        if (pureNumbers[0] + pureNumbers[1] >= pureNumbers[2]) {
            pureNumbers[0] = 5;
            pureNumbers[1] = 0;
            pureNumbers[2] = 10;
        }
        return pureNumbers;
    }

    public static void main(String[] args) {
        NumberGuesser numberGuesser = new NumberGuesser();
    }

}
