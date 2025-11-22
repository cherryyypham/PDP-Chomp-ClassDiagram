package Controller;

import Model.Player;

abstract class Game {
    Player[] players;
    int currentPlayerIndex;

    protected Game(Player[] players) {
        this.players = players;
        this.currentPlayerIndex = 0;
    }

//    public void start() {
//
//    }

    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

//    public void endGame() {
//    }

    public abstract void playTurn();
    public abstract boolean isGameOver();
    public abstract Player getWinner();
}
