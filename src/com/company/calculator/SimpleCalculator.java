package com.company.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    JLabel displayLabel = new JLabel(" ");
    private double firstNumber;
    private double secondNumber;
    private String operator;


    public SimpleCalculator() {
        JPanel calculatorButtonPanel = new JPanel();
        calculatorButtonPanel.setLayout(new GridLayout(4, 4));
        // Define display label and position.
        this.getContentPane().add(displayLabel, BorderLayout.NORTH);
        // Define grid with content and position.
        this.getContentPane().add(calculatorButtonPanel, BorderLayout.CENTER);
        createButtonPanel(calculatorButtonPanel);

        // Draw full calculator panel.
        deployFrame();
    }

    private void createButtonPanel(JPanel calculatorButtonPanel) {

        String[] buttonsArray = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "+",
                "C", "0", "=", "-"};

        for (String label : buttonsArray
        ) {
            JButton button = new JButton(label);
            calculatorButtonPanel.add(button);
            button.addActionListener(this);
        }
    }

    private void deployFrame() {
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentButton = e.getActionCommand();
        switch (currentButton) {

            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                displayLabel.setText(displayLabel.getText() + currentButton);
                break;
            case "/":
            case "*":
            case "+":
            case "-":
                operator = currentButton;
                firstNumber = Double.parseDouble(displayLabel.getText().strip());
                displayLabel.setText(" ");
                break;
            case "C":
                firstNumber = secondNumber = 0;
                displayLabel.setText(" ");
                break;
            case "=":
                secondNumber = Double.parseDouble(displayLabel.getText().strip());
                double result = 0;
                switch (operator) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                }
                displayLabel.setText(result + "");
                break;
        }
    }

    public static void main(String[] args) {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
    }

}
