package com.aurionpro.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.aurionpro.model.TicTacToeGame;


public class TicTacToeGameTest {
    public static void main(String[] args) {
        TicTacToeGame gameFacade = new TicTacToeGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe Game!");
        gameFacade.printBoard();

        String winner = null;

        while (winner == null) {
            int numberInput;

            System.out.println(gameFacade.getCurrentTurn() + "'s turn; Enter a slot number to place " + gameFacade.getCurrentTurn() + " in: ");

            try {
                numberInput = scanner.nextInt();
                if (!(numberInput > 0 && numberInput <= 9)) {
                    System.out.println("Invalid Input, re-enter slot number: ");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input, re-enter slot number: ");
                scanner.next(); // Clear the invalid input
                continue;
            }

            boolean moveMade = gameFacade.makeMove(numberInput);
            if (moveMade) {
                gameFacade.printBoard();
                winner = gameFacade.checkWinner();
            } else {
                System.out.println("Slot already taken, re-enter slot number: ");
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
    }
}
