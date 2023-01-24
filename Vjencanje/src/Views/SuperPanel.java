package Views;

import javax.swing.*;
import java.awt.*;

public class SuperPanel {
    protected JPanel panel = new JPanel();
    private JLabel titleLabel = new JLabel();

    public SuperPanel(String title) {
        panel.setBounds(0, 0, 500, 400);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        titleLabel.setText(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel);
    }

    public JPanel getPanel() {
        return panel;
    }
}
