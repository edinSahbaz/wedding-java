package Views;

import Models.Fotograf;
import Models.Pice;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

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

    protected void configureInput(JTextField textField, String label) {
        JLabel txtFieldLabel = new JLabel();
        txtFieldLabel.setText(label);
        panel.add(txtFieldLabel);

        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setPreferredSize(new Dimension(400, 24));
        panel.add(textField);
    }

    protected void configureBtn(JButton btn, String btnText, Runnable eventFunction) {
        btn.setText(btnText);
        btn.addActionListener(e -> {
            eventFunction.run();
        });

        panel.add(btn);
    }
}
