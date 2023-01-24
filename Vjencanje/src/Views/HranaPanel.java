package Views;

import Data.Tables.HranaTable;
import Data.VjencanjeData;
import Models.Hrana;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class HranaPanel extends SuperPanel {
    private HranaTable hranaTable;
    private JTextField nameTxtFiled = new JTextField();
    private JButton addBtn = new JButton();
    private JButton showAllBtn = new JButton();
    private JTextField idTxtFiled = new JTextField();
    private JButton updateBtn = new JButton();
    private JButton deleteBtn = new JButton();
    private JButton getByIdBtn = new JButton();


    public HranaPanel(VjencanjeData vjencanjeData) {
        super("Hrana");
        this.hranaTable = vjencanjeData.getHranaTable();

        configureNameInput();
        configureAddBtn();
        panel.add(new JSeparator());
        configureShowBtn();
        panel.add(new JSeparator());
        configureIdInput();
        configureGetByIdBtn();
        configureUpdateBtn();
        configureDeleteBtn();
    }

    private void configureNameInput() {
        JLabel txtFieldLabel = new JLabel();
        txtFieldLabel.setText("Naziv");
        panel.add(txtFieldLabel);

        nameTxtFiled.setFont(new Font("Arial", Font.BOLD, 24));
        nameTxtFiled.setPreferredSize(new Dimension(400, 24));
        panel.add(nameTxtFiled);
    }

    private void configureIdInput() {
        JLabel txtFieldLabel = new JLabel();
        txtFieldLabel.setText("Id");
        panel.add(txtFieldLabel);

        idTxtFiled.setFont(new Font("Arial", Font.BOLD, 24));
        idTxtFiled.setPreferredSize(new Dimension(400, 24));
        panel.add(idTxtFiled);
    }

    private void configureAddBtn() {
        addBtn.setText("Dodaj Hranu");
        addBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();

            if(name.length() < 1) {
                JOptionPane.showMessageDialog(panel, "Unesite naziv paketa hrane!");
            } else {
                int id = hranaTable.getNewId();
                Hrana newHrana = new Hrana(id, name);
                hranaTable.insert(newHrana);
            }
        });

        panel.add(addBtn);
    }

    private void configureShowBtn() {
        showAllBtn.setText("Prikazi Hranu");
        showAllBtn.addActionListener(e -> {
            LinkedHashMap<Integer, Hrana> returnData = hranaTable.selectAll();

            String output = "";

            for (int id : returnData.keySet()) {
                Hrana temp = returnData.get(id);
                output += temp.toString() + "\n";
            }

            JOptionPane.showMessageDialog(panel, output);
        });

        panel.add(showAllBtn);
    }

    private void configureDeleteBtn() {
        deleteBtn.setText("Obrisi Hranu za uneseni ID");
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());

            if(hranaTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Zapis ne postoji!");
            } else {
                hranaTable.delete(id);
            }
        });

        panel.add(deleteBtn);
    }

    private void configureUpdateBtn() {
        updateBtn.setText("Update Hranu za uneseni ID");
        updateBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();
            int id = Integer.parseInt(idTxtFiled.getText());

            if(name.length() < 1 || hranaTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Naziv ili id pogrešni!");
            } else {
                Hrana newHrana = new Hrana(id, name);
                hranaTable.update(id, newHrana);
            }
        });

        panel.add(updateBtn);
    }

    private void configureGetByIdBtn() {
        getByIdBtn.setText("Prikazi Hranu za uneseni ID");
        getByIdBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());
            Hrana returnData = hranaTable.selectById(id);
            String output = "";

            if(returnData == null) {
                output = "Pogrešan id!";
            } else {
                output = returnData.toString();
            }

            JOptionPane.showMessageDialog(panel, output);
        });

        panel.add(getByIdBtn);
    }
}
