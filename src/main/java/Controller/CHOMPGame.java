package Controller;

import View.Display;
import Model.Board;
import Model.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Chomp game. Main controller of the program.
 *
 * Orchestrates gameplay by coordinating Board updates and Display refreshes.
 */
public class CHOMPGame extends Game implements ActionListener {
    private final Board board;
    private final Display display;
    private boolean gameOver;

    /**
     * Instantiates a new Chomp game.
     *
     * @param rows        the original rows of the game's chocolate bar
     * @param cols        the original cols of the game's chocolate bar
     * @param player1Name the player 1 name
     * @param player2Name the player 2 name
     */
    public CHOMPGame(int rows, int cols, String player1Name, String player2Name) {
        super(new Player[]{new Player(player1Name), new Player(player2Name)});
        board = new Board(rows, cols);
        display = new Display(board);
        gameOver = false;

        // Connect controller as event handler for all buttons
        display.setActionListener(this);
        display.setResetButtonListener(this);

        // Display initial message to start game
        display.updateInfoPanel("Game Start! " + getCurrentPlayer().getName() + "'s turn.");
    }

    /**
     * Executes a turn with the specified move.
     *
     * Updates the board, refreshes display, checks for game over, and switches player if game continues.
     * @param row row of the selected cell
     * @param col col of the selected cell
     */
    private void playTurn(int row, int col) {
        // Update board model
        board.makeMove(row, col);

        // Refresh board display
        display.showBoard();

        // Check game over and handle accordingly
        if(isGameOver()) {
            Player winner = getWinner();
            display.updateInfoPanel("Game Over! " + winner.getName() + " won!");
            gameOver = true;
        } else {
            // If not game over, continue to next player's turn
            switchPlayer();
            display.updateInfoPanel(getCurrentPlayer().getName() + "'s turn.");
        }
    }

    /**
     * Template method implementation - not used.
     *
     * Handled by actionPerformed in event-driven architecture.
     */
    @Override
    public void playTurn() {
        // Modifying given playTurn() architecture w/ args
    }

    /**
     * Resets game to initial state without initiating a new Board object.
     *
     * Clears board, reset to player 1, update display.
     */
    private void resetGame() {
        board.reset();
        currentPlayerIndex = 0;
        gameOver = false;
        display.showBoard();
        display.updateInfoPanel("Game Start! " + getCurrentPlayer().getName() + "'s turn.");
    }

    /**
     * Checks if the game has ended - if the poison cell (0,0) is eaten.
     *
     * @return true if poison cell is eaten, false otherwise
     */
    @Override
    public boolean isGameOver() {
        return board.isPoisonEaten();
    }

    /**
     * Determines the winner of the game.
     *
     * @return the player who is not the one that ate the poison cell.
     */
    @Override
    public Player getWinner() {
        return players[(currentPlayerIndex + 1) % players.length];
    }

    /**
     * Handles all button clicks using game logic.
     * - Board buttons: validate move, update board, check for game over.
     * - Reset button: restarts game
     *
     * @param e the event to be processed containing button information
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if reset button was clicked (has no coordinates in command)
        if (e.getActionCommand() == null || e.getActionCommand().equals("Reset")) {
            resetGame();
            return;
        }

        // Disable game board if game is over (unless reset is clicked)
        if (gameOver) return;

        // Extract row and column from button's ActionCommand
        String command = e.getActionCommand();
        String[] parts = command.split(",");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);

        // Validate that the selected cell is available
        if (board.isCellAvailable(row, col)) {
            playTurn(row, col);
        }
    }
}
