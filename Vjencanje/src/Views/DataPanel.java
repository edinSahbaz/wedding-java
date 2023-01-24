package Views;

import javax.swing.*;
import java.awt.*;

public class DataPanel {
    private JPanel panel = new JPanel();

    public DataPanel() {
        panel.setBounds(280, 60, 500, 400);
        panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanelContent(JPanel newPanel) {
        panel.removeAll();
        panel.add(newPanel);
        panel.validate();
        panel.repaint();
    }
}
