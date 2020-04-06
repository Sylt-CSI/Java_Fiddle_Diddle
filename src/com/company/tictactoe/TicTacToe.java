package com.company.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class TicTacToe implements ActionListener {
    private int[][] internalTicTacToeBoard = new int[3][3];
    private HashMap<String, JButton> jButtonElementsHashMap = new HashMap<String, JButton>();
    private String activePlayer = "X";
    private JLabel turnLabel = new JLabel("Turn X");
    private JLabel textualScoreBoard = new JLabel();
    private int moveCounter = 0;
    private int currentGameWinner;
    private int[] scoreBoardValues = {0, 0, 0};

    public TicTacToe() {
        modifyScoreBoardScores();
        JFrame newFrame = new JFrame();
        JPanel ticTacToePanelLayout = new JPanel();
        ticTacToePanelLayout.setLayout(new GridLayout(3, 3));
        generateTicTacToeButtonBoard(ticTacToePanelLayout);
        newFrame.getContentPane().add(turnLabel, BorderLayout.NORTH);
        newFrame.getContentPane().add(textualScoreBoard, BorderLayout.SOUTH);
        newFrame.getContentPane().add(ticTacToePanelLayout, BorderLayout.CENTER);

        deployFrame(newFrame);
    }

    private void deployFrame(JFrame newFrame) {
        newFrame.setSize(400, 400);
        newFrame.setVisible(true);
        newFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void generateTicTacToeButtonBoard(JPanel jPanelTicTacToePlayBoard) {
        for (int index = 0; index < 9; index++) {
            // Yugh not dynamic.
            if (index < 3) {
                makeButton(jPanelTicTacToePlayBoard, index, 0, 0);
            } else if (index < 6) {
                makeButton(jPanelTicTacToePlayBoard, index, 1, -3);
            } else {
                makeButton(jPanelTicTacToePlayBoard, index, 2, -6);
            }
        }
    }

    private void makeButton(JPanel jPanelTicTacToePlayBoard, int row, int column, int subtraction) {
        JButton jButton = new JButton("");
        jPanelTicTacToePlayBoard.add(jButton);
        jButton.addActionListener(this);
        jButton.setActionCommand((row + subtraction) + "," + column);
        jButtonElementsHashMap.put((row + subtraction) + "," + column, jButton);
    }

    private void resetBoard() {
        activePlayer = "X";
        System.out.println(Arrays.toString(scoreBoardValues));
        modifyScoreBoardScores();
        for (int[] row : internalTicTacToeBoard
        ) {
            Arrays.fill(row, 0);
        }
        for (String textualIndex : jButtonElementsHashMap.keySet()
        ) {
            jButtonElementsHashMap.get(textualIndex).setText("");
        }
        moveCounter = 0;
        currentGameWinner = 0;
    }

    private void modifyScoreBoardScores() {
        String templateScoreBoardText = "Scoreboard: X wins: %d, O wins: %d, Stalemates: %d";
        String scoreBoardText = String.format(templateScoreBoardText, scoreBoardValues[0], scoreBoardValues[1], scoreBoardValues[2]);
        System.out.println(scoreBoardText);
        textualScoreBoard.setText(scoreBoardText);
    }

    private void validateHorizontalStructure() {
        System.out.println(moveCounter);
        for (int[] horizontalRow : this.internalTicTacToeBoard) {
            if (IntStream.of(horizontalRow).sum() == this.internalTicTacToeBoard.length) {
                System.out.println("X wins!");
                currentGameWinner = 3;
            } else if (IntStream.of(horizontalRow).sum() == -this.internalTicTacToeBoard.length) {
                System.out.println("O wins!");
                currentGameWinner = -3;
            } else if (moveCounter == 9 && IntStream.of(horizontalRow).anyMatch(x -> x != 0)) {
                System.out.println("Stalemate detected on row!");
                currentGameWinner = 1337;
            }
        }
    }

    private void validateVerticalStructure() {
        for (int index = 0; index < this.internalTicTacToeBoard.length; index++) {
            //Yugh, only works for 3 x 3 matrix.
            if (IntStream.of(internalTicTacToeBoard[0][index] + internalTicTacToeBoard[1][index] + internalTicTacToeBoard[2][index]).sum() == this.internalTicTacToeBoard.length) {
                System.out.println("X wins!");
                currentGameWinner = 3;
            } else if (IntStream.of(internalTicTacToeBoard[0][index] + internalTicTacToeBoard[1][index] + internalTicTacToeBoard[2][index]).sum() == -this.internalTicTacToeBoard.length) {
                System.out.println("O wins!");
                currentGameWinner = -3;
            }
        }
    }

    private void validateDiagonalStructure() {
        //Yugh, only works for 3 x 3 matrix.
        if (IntStream.of(internalTicTacToeBoard[0][0] + internalTicTacToeBoard[1][1] + internalTicTacToeBoard[2][2]).sum() == this.internalTicTacToeBoard.length || IntStream.of(internalTicTacToeBoard[2][0] + internalTicTacToeBoard[1][1] + internalTicTacToeBoard[0][2]).sum() == this.internalTicTacToeBoard.length) {
            System.out.println("X wins!");
            currentGameWinner = 3;
        } else if (IntStream.of(internalTicTacToeBoard[0][0] + internalTicTacToeBoard[1][1] + internalTicTacToeBoard[2][2]).sum() == -this.internalTicTacToeBoard.length || IntStream.of(internalTicTacToeBoard[2][0] + internalTicTacToeBoard[1][1] + internalTicTacToeBoard[0][2]).sum() == -this.internalTicTacToeBoard.length) {
            System.out.println("O wins!");
            currentGameWinner = -3;
        }
    }

    private void makeAMoveOnTheBoard(String locationOnBoard) {
        int[] positionsArray = getIntIndexPositionsFromString(locationOnBoard);
        if (activePlayer.equals("X")) {
            internalTicTacToeBoard[positionsArray[0]][positionsArray[1]] = 1;
            activePlayer = "O";
        } else if (activePlayer.equals("O")) {
            internalTicTacToeBoard[positionsArray[0]][positionsArray[1]] = -1;
            activePlayer = "X";
        }
        System.out.println(Arrays.deepToString(internalTicTacToeBoard));
    }

    private int[] getIntIndexPositionsFromString(String textualPosition) {
        String[] stringPositionsArray = textualPosition.split(",");
        return new int[]{Integer.parseInt(stringPositionsArray[0]), Integer.parseInt(stringPositionsArray[1])};
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentButton = e.getActionCommand();
        System.out.println(currentButton);
        String gameButtonValue = jButtonElementsHashMap.get(currentButton).getText();
        if (gameButtonValue.equals("X") || gameButtonValue.equals("O")) {
            System.out.println("Invalid move.");
        } else {
            jButtonElementsHashMap.get(currentButton).setText(activePlayer);
            moveCounter++;
            System.out.println(moveCounter);
            makeAMoveOnTheBoard(currentButton);
            validateDiagonalStructure();
            validateVerticalStructure();
            validateHorizontalStructure();
            turnLabel.setText("Turn: " + activePlayer);
            if (currentGameWinner == 3) {
                System.out.println("X Wins!");
                scoreBoardValues[0]++;
                resetBoard();
            } else if (currentGameWinner == -3) {
                System.out.println("O Wins!");
                scoreBoardValues[1]++;
                resetBoard();
            } else if (currentGameWinner == 1337) {
                System.out.println("Stalemate!");
                scoreBoardValues[2]++;
                resetBoard();
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
    }
}
