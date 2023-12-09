import minesweeper.HomeFrame;

import javax.swing.*;


public class minesweeper {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeFrame homeFrame = new HomeFrame();
        });
    }
}
