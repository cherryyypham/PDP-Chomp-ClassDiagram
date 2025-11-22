package View;

import Model.Board;

import java.awt.event.ActionListener;

public class Display {
    private final InfoPanel infoPanel;
    private final GamePanel gamePanel;

    public Display(Board board) {
        Frame frame = new Frame(board);
        gamePanel = frame.getGamePanel();
        infoPanel = frame.getInfoPanel();
    }

    public void showBoard() {
        gamePanel.repaint();
    }

    public void setActionListener(ActionListener actionListener) {
        gamePanel.setActionListener(actionListener);
    }

    public void updateInfoPanel(String info) {
        infoPanel.updateInfo(info);
    }
}
