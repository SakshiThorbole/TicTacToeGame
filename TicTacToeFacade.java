package com.aurionpro.model;

import com.aurionpro.model.TicTacToeGame;

public class TicTacToeFacade {
    private TicTacToeGame game;

    public TicTacToeFacade() {
        game = new TicTacToeGame();
    }

    public void printBoard() {
        game.printBoard();
    }

    public boolean makeMove(int slot) {
        return game.makeMove(slot);
    }

    public String checkWinner() {
        return game.checkWinner();
    }

    public String getCurrentTurn() {
        return game.getCurrentTurn();
    }
}
