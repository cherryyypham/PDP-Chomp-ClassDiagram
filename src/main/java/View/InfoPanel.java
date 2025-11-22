package View;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private final JLabel infoLabel;

    public InfoPanel() {
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        infoLabel = new JLabel("", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(infoLabel);
    }

    public void updateInfo(String info) {
        infoLabel.setText(info);
    }
}
