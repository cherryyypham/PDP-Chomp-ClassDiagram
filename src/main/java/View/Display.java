package View;

import Model.Board;

import java.awt.event.ActionListener;

/**
 * The type Display.    Represents the view manager that bridges game logic and GUI components.
 *
 * Centralizes UI update. Coordinates between Frame and its panels. Connect with CHOMPGame through action listener.
 */
public class Display {
    private final InfoPanel infoPanel;
    private final GamePanel gamePanel;

    /**
     * Instantiates a new Display.
     *
     * @param board the Board object to display
     */
    public Display(Board board) {
        Frame frame = new Frame(board);
        gamePanel = frame.getGamePanel();
        infoPanel = frame.getInfoPanel();
    }

    /**
     * Refreshes the visual representation of the board.
     *
     * Triggers repaint to update button states based on current Board states.
     */
    public void showBoard() {
        gamePanel.repaint();
    }

    /**
     * Connects the game controller as the event handler for chomp squares clicks.
     *
     * @param actionListener the action listener to handle Chomp game clicks
     */
    public void setActionListener(ActionListener actionListener) {
        gamePanel.setActionListener(actionListener);
    }

    /**
     * Connects the game controller as the event handler for the reset buttons.
     * @param actionListener the action listener to handle reset button clicks
     */
    public void setResetButtonListener(ActionListener actionListener) {
        infoPanel.setResetButtonListener(actionListener);
    }

    /**
     * Update the message displayed in the information panel.
     *
     * @param info the info to be displayed
     */
    public void updateInfoPanel(String info) {
        infoPanel.updateInfo(info);
    }
}
