package View;

import Model.Board;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private final InfoPanel infoPanel;
    private final GamePanel gamePanel;

    public Frame(Board board) {
        super("Chomp Game");
        this.gamePanel = new GamePanel(board);
        this.infoPanel = new InfoPanel();

        setUpFrame();
    }

    private void setUpFrame() {
        setLayout(new BorderLayout(30, 10));
        add(infoPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public InfoPanel getInfoPanel() {
        return infoPanel;
    }
}
