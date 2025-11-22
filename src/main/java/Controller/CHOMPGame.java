package Controller;

import View.Display;
import Model.Board;
import Model.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CHOMPGame extends Game implements ActionListener {
    private final Board board;
    private final Display display;
    private boolean gameOver;

    public CHOMPGame(int rows, int cols, String player1Name, String player2Name) {
        super(new Player[]{new Player(player1Name), new Player(player2Name)});
        board = new Board(rows, cols);
        display = new Display(board);
        gameOver = false;

        display.setActionListener(this);
        display.updateInfoPanel("Game Start! " + getCurrentPlayer().getName() + "'s turn.");
    }

    private void playTurn(int row, int col) {
        board.makeMove(row, col);
        display.showBoard();

        if(isGameOver()) {
            Player winner = getWinner();
            display.updateInfoPanel("Game Over! " + winner.getName() + " won!");
            gameOver = true;
        } else {
            switchPlayer();
            display.updateInfoPanel(getCurrentPlayer().getName() + "'s turn.");
        }
    }

    @Override
    public void playTurn() {
    // Modifying given playTurn() architecture w/ args
    }

    @Override
    public boolean isGameOver() {
        return board.isPoisonEaten();
    }

    @Override
    public Player getWinner() {
        return players[(currentPlayerIndex + 1) % players.length];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        String command = e.getActionCommand();
        String[] parts = command.split(",");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);

        if (board.isCellAvailable(row, col)) {
            playTurn(row, col);
        }
    }
}
