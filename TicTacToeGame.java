package com.aurionpro.model;

import java.util.Arrays;

public class TicTacToeGame {
    public String[] board;
    public String turn;

    public TicTacToeGame() {  // Constructor
        board = new String[9];
        turn = "X";
        for (int i = 0; i < 9; i++) {         // fills the board array with the string representations.
            board[i] = String.valueOf(i + 1);
        }
    }

    public void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " | ");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " | ");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " | ");
        System.out.println("|---|---|---|");
    }

    public boolean makeMove(int slot) {   // place the current player's mark (either "X" or "0") in the specified slot on the board.
        if (board[slot - 1].equals(String.valueOf(slot))) {  // slot on the board is equal to the string representation of slot number, it means the slot unoccupied.
            board[slot - 1] = turn;                          // mark (turn), either "X" or "0".
            turn = turn.equals("X") ? "0" : "X";            // Toggles the turn.
            return true;
        }
        return false;
    }

    public String checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("000")) {
                return "0";
            }
        }
        for (int i = 0; i < 9; i++) {     // checks whether there are any remaining empty slots on the board.
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                return null;          // Game is ongoing
            }
        }
        return "draw";
    }

    public String getCurrentTurn() {
        return turn;
    }
}
