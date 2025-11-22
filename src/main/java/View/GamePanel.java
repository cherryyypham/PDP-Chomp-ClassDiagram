package View;

import Model.Cell;
import Model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Game panel. Contains the game board represented as a grid of buttons.
 *
 * Each button can be clicked to be eaten.
 * Handles visual updates to reflect the current board state.
 */
public class GamePanel extends JPanel {
    /**
     * Reference to the Board model to check cell states.
     */
    Board board;
    /**
     * 2D array of buttons representing clickable chocolate squares in Chomp.
     */
    JButton[][] buttons;

    /**
     * Instantiates a new Game panel matching Board object.
     *
     * @param board the board to be displayed
     */
    public GamePanel(Board board) {
        this.board = board;
        int rows = board.getRows();
        int cols = board.getCols();

        setLayout(new GridLayout(rows, cols, 5, 3));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(20, 20,20,20)
                ));
        buttons = new JButton[rows][cols];

        for (int r =  rows-1; r >= 0; r--) {
            for (int c = 0; c < cols; c++) {
                buttons[r][c] = new JButton();
                buttons[r][c].setActionCommand(r + "," + c);
                buttons[r][c].setPreferredSize(new Dimension(60, 60));
                buttons[r][c].setContentAreaFilled(true);
                buttons[r][c].setFocusPainted(false);
                buttons[r][c].setBorderPainted(false);
                buttons[r][c].setOpaque(true);
                add(buttons[r][c]);
            }
        }
    }

    /**
     * Sets action listener for all buttons in the grid.
     *
     * @param actionListener the action listener for cell button clicks.
     */
    public void setActionListener(ActionListener actionListener) {
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[r].length; c++) {
                buttons[r][c].addActionListener(actionListener);
            }
        }
    }

    /**
     * Overrides itself to update button state when panel is repaint
     * ed.
     * @param g the <code>Graphics</code> object for painting
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateButtons();
    }

    /**
     * Update all buttons based on current board state.
     *
     * Set colors and enable states according to cell status:
     * - Gray: eaten squares
     * - Red: poison square, trigger game over
     * - Brown: uneaten, clickable squares
     */
    public void updateButtons() {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                Cell cell = board.getCell(r, c);
                if (cell.isEaten()) {
                    buttons[r][c].setBackground(Color.GRAY);
                    buttons[r][c].setEnabled(false);
                } else {
                    if (r == 0 && c == 0) {
                        buttons[r][c].setBackground(Color.RED);
                    } else {
                        buttons[r][c].setBackground(new Color(150, 70, 0));
                    }
                    buttons[r][c].setEnabled(true);
                }
            }
        }
    }

}
