package View;

import Model.Board;

import javax.swing.*;
import java.awt.*;

/**
 * The type Frame.  Extends JFrame to make Chomp game application window.
 */
public class Frame extends JFrame {
    private final InfoPanel infoPanel;
    private final GamePanel gamePanel;

    /**
     * Instantiates a new Frame.
     *
     * @param board the Board model to display
     */
    public Frame(Board board) {
        super("Chomp Game");
        this.gamePanel = new GamePanel(board);
        this.infoPanel = new InfoPanel();

        setUpFrame();
    }

    /**
     * Configures frame properties and layout.
     * Arranges panels as per architecture notes:
     * - Instruction - top
     * - Game Board - center
     */
    private void setUpFrame() {
        setLayout(new BorderLayout(30, 10));

        ((JPanel)getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(80, 80, 80, 80)
        );
        add(infoPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    /**
     * Getter for game panel.
     *
     * @return the GamePanel instance
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * Getter for info panel.
     *
     * @return the infoPanel instance
     */
    public InfoPanel getInfoPanel() {
        return infoPanel;
    }
}
