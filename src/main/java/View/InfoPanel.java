package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Info panel. Displays game status information and controls.
 *
 * Show current turn information or game over messages.
 * (Not included in architecture) Houses reset button to refresh to a new game.
 */
public class InfoPanel extends JPanel {
    // Label displaying status messages to user
    private final JLabel infoLabel;

    // Button for resetting the game
    private final JButton resetButton;

    /**
     * Instantiates a new Info panel.
     */
    public InfoPanel() {
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        infoLabel = new JLabel("", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(infoLabel);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.setFocusPainted(false);
        add(resetButton);
    }

    /**
     * Update info displayed in the panel.
     *
     * @param info the info to be displayed
     */
    public void updateInfo(String info) {
        infoLabel.setText(info);
    }

    /**
     * Sets the action listener for the reset button. (not in architecture)
     *
     * @param actionListener
     */
    public void setResetButtonListener(ActionListener actionListener) {
        if (resetButton != null) {
            resetButton.addActionListener(actionListener);
        }
    }
}
