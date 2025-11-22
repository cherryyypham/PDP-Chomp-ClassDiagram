package View;

import Model.Cell;
import Model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    Board board;
    JButton[][] buttons;

    public GamePanel(Board board) {
        this.board = board;
        int rows = board.getRows();
        int cols = board.getCols();

        setLayout(new GridLayout(rows, cols, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttons = new JButton[rows][cols];

        for (int r =  0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[r].length; c++) {
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

    public void setActionListener(ActionListener actionListener) {
        for (int r = 0; r < buttons.length; r++) {
            for (int c = 0; c < buttons[r].length; c++) {
                buttons[r][c].addActionListener(actionListener);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateButtons();
    }

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
