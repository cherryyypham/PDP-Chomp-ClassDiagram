package Controller;

import Model.Player;

/**
 * Abstract class for turn-based games.
 *
 * Implement the Template Method design pattern by defining a skeleton of managing players and turns while leaving
 * specific game logic to subclasses.
 */
abstract class Game {
    /**
     * Array of players participating in the game
     */
    Player[] players;
    /**
     * The Current player index.
     */
    int currentPlayerIndex;

    /**
     * Instantiates a new Game with specified list of players.
     *
     * @param players the players
     */
    protected Game(Player[] players) {
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    /**
     * Switch player using modulo arithmetic.
     */
    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    /**
     * Gets current player whose turn it currently is.
     *
     * @return the current Player object
     */
    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    /**
     * Template method for executing a turn.
     */
    public abstract void playTurn();

    /**
     * Template method for checking if the game has ended.
     *
     * @return true if the game is over, false otherwise
     */
    public abstract boolean isGameOver();

    /**
     * Template method for determining the winner.
     *
     * @return the winner
     */
    public abstract Player getWinner();
}
