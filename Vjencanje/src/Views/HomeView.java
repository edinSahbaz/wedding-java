package Views;

import Data.VjencanjeData;
import Models.Pice;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class HomeView {
    private VjencanjeData vjencanjeData;
    JFrame frame = new JFrame("Vjenčanje - JAVA");
    private JLabel titleLabel = new JLabel();
    private DataPanel dataPanel = new DataPanel();
    // Buttons for opening forms to add Class specific data
    private JButton openHranaBtn = new JButton();
    private JButton openPiceBtn = new JButton();
    private JButton openCateringBtn = new JButton();
    private JButton openPaketBtn = new JButton();
    private JButton openFotografBtn = new JButton();
    private JButton openMaticarBtn = new JButton();
    private JButton openTemaBtn = new JButton();
    private JButton openSalaBtn = new JButton();
    private JButton openLokacijaBtn = new JButton();
    private JButton openUlogaBtn = new JButton();
    private JButton openOsobaBtn = new JButton();
    private JButton openVjencanjeBtn = new JButton();
    private JButton openRacunBtn = new JButton();
    LinkedHashMap<String, JButton> buttonsMap;
    HashMap<String, JPanel> panelsMap;

    public HomeView() {
        vjencanjeData = new VjencanjeData();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(null);
        frame.setResizable(false);

        setTitle();
        populateMaps();
        configureButtons();

        frame.add(dataPanel.getPanel());
        frame.setVisible(true);
    }

    private void setTitle() {
        titleLabel.setText("Vjenčanje - JAVA");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(300, 10, 200, 30);
        frame.add(titleLabel);
    }

    private void populateMaps() {
        buttonsMap = new LinkedHashMap<>();
        panelsMap = new HashMap<>();

        buttonsMap.put("Hrana", openHranaBtn);
        panelsMap.put("Hrana", new HranaPanel(vjencanjeData).getPanel());

        buttonsMap.put("Pice", openPiceBtn);
        panelsMap.put("Pice", new PicePanel(vjencanjeData).getPanel());

        buttonsMap.put("Catering", openCateringBtn);
        buttonsMap.put("Paket", openPaketBtn);
        buttonsMap.put("Fotograf", openFotografBtn);
        buttonsMap.put("Maticar", openMaticarBtn);
        buttonsMap.put("Tema", openTemaBtn);
        buttonsMap.put("Sala", openSalaBtn);
        buttonsMap.put("Lokacija", openLokacijaBtn);
        buttonsMap.put("Uloga", openUlogaBtn);
        buttonsMap.put("Osoba", openOsobaBtn);
        buttonsMap.put("Vjencanje", openVjencanjeBtn);
        buttonsMap.put("Racun", openRacunBtn);
    }

    private void configureButtons() {
        int width = 200;
        int height = 20;
        int x = 40;
        int y = 70;

        for (String btnKey : buttonsMap.keySet()) {
            JButton btn = buttonsMap.get(btnKey);
            setButton(btn, btnKey, x, y, width, height);
            y += 30;
        }
    }

    private void setButton(JButton btn, String text, int x, int y, int width, int height) {
        btn.setText(text);
        btn.setFont(new Font("Arial", Font.PLAIN, 14));
        btn.setBounds(x, y, width, height);

        btn.addActionListener(e -> {
            JPanel panel = panelsMap.get(text);
            dataPanel.setPanelContent(panel);
        });

        frame.add(btn);
    }
}
