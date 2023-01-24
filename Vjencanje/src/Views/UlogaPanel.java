package Views;

import Data.Tables.HranaTable;
import Data.Tables.PiceTable;
import Data.Tables.UlogaTable;
import Data.VjencanjeData;
import Models.Hrana;
import Models.Pice;
import Models.Uloga;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class UlogaPanel extends SuperPanel {
    private UlogaTable ulogaTable;
    private JTextField nameTxtFiled = new JTextField();
    private JButton addBtn = new JButton();
    private JButton showAllBtn = new JButton();
    private JTextField idTxtFiled = new JTextField();
    private JButton updateBtn = new JButton();
    private JButton deleteBtn = new JButton();
    private JButton getByIdBtn = new JButton();


    public UlogaPanel(VjencanjeData vjencanjeData) {
        super("Uloga");
        this.ulogaTable = vjencanjeData.getUlogaTable();

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
        nameTxtFiled.setFont(new Font("Arial", Font.BOLD, 24));
        nameTxtFiled.setPreferredSize(new Dimension(400, 24));
        panel.add(nameTxtFiled);
    }

    private void configureIdInput() {
        idTxtFiled.setFont(new Font("Arial", Font.BOLD, 24));
        idTxtFiled.setPreferredSize(new Dimension(400, 24));
        panel.add(idTxtFiled);
    }

    private void configureAddBtn() {
        addBtn.setText("Dodaj Ulogu");
        addBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();

            if(name.length() < 1) {
                JOptionPane.showMessageDialog(panel, "Unesite naziv uloge!");
            } else {
                int id = ulogaTable.getNewId();
                Uloga newUloga = new Uloga(id, name);
                ulogaTable.insert(newUloga);
            }
        });

        panel.add(addBtn);
    }

    private void configureShowBtn() {
        showAllBtn.setText("Prikazi Uloge");
        showAllBtn.addActionListener(e -> {
            LinkedHashMap<Integer, Uloga> returnData = ulogaTable.selectAll();

            String output = "";

            for (int id : returnData.keySet()) {
                Uloga temp = returnData.get(id);
                output += temp.toString() + "\n";
            }

            JOptionPane.showMessageDialog(panel, output);
        });

        panel.add(showAllBtn);
    }

    private void configureDeleteBtn() {
        deleteBtn.setText("Obrisi Ulogu za uneseni ID");
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());

            if(ulogaTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Zapis ne postoji!");
            } else {
                ulogaTable.delete(id);
            }
        });

        panel.add(deleteBtn);
    }

    private void configureUpdateBtn() {
        updateBtn.setText("Update Ulogu za uneseni ID");
        updateBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();
            int id = Integer.parseInt(idTxtFiled.getText());

            if(name.length() < 1 || ulogaTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Naziv ili id pogrešni!");
            } else {
                Uloga newUloga = new Uloga(id, name);
                ulogaTable.update(id, newUloga);
            }
        });

        panel.add(updateBtn);
    }

    private void configureGetByIdBtn() {
        getByIdBtn.setText("Prikazi Ulogu za uneseni ID");
        getByIdBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());
            Uloga returnData = ulogaTable.selectById(id);
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
