package Views;

import Data.Tables.HranaTable;
import Data.Tables.PiceTable;
import Data.VjencanjeData;
import Models.Hrana;
import Models.Pice;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class PicePanel extends SuperPanel {
    private PiceTable piceTable;
    private JTextField nameTxtFiled = new JTextField();
    private JButton addBtn = new JButton();
    private JButton showAllBtn = new JButton();
    private JTextField idTxtFiled = new JTextField();
    private JButton updateBtn = new JButton();
    private JButton deleteBtn = new JButton();
    private JButton getByIdBtn = new JButton();


    public PicePanel(VjencanjeData vjencanjeData) {
        super("Pice");
        this.piceTable = vjencanjeData.getPiceTable();

        configureInput(nameTxtFiled, "Naziv");
        configureAddBtn();
        panel.add(new JSeparator());
        configureShowBtn();
        panel.add(new JSeparator());
        configureInput(idTxtFiled, "Id");
        configureGetByIdBtn();
        configureUpdateBtn();
        configureDeleteBtn();
    }

    private void configureAddBtn() {
        addBtn.setText("Dodaj Pice");
        addBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();

            if(name.length() < 1) {
                JOptionPane.showMessageDialog(panel, "Unesite naziv paketa pica!");
            } else {
                int id = piceTable.getNewId();
                Pice newPice = new Pice(id, name);
                piceTable.insert(newPice);
            }
        });

        panel.add(addBtn);
    }

    private void configureShowBtn() {
        showAllBtn.setText("Prikazi Pice");
        showAllBtn.addActionListener(e -> {
            LinkedHashMap<Integer, Pice> returnData = piceTable.selectAll();

            String output = "";

            for (int id : returnData.keySet()) {
                Pice temp = returnData.get(id);
                output += temp.toString() + "\n";
            }

            JOptionPane.showMessageDialog(panel, output);
        });

        panel.add(showAllBtn);
    }

    private void configureDeleteBtn() {
        deleteBtn.setText("Obrisi Pice za uneseni ID");
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());

            if(piceTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Zapis ne postoji!");
            } else {
                piceTable.delete(id);
            }
        });

        panel.add(deleteBtn);
    }

    private void configureUpdateBtn() {
        updateBtn.setText("Update Pice za uneseni ID");
        updateBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();
            int id = Integer.parseInt(idTxtFiled.getText());

            if(name.length() < 1 || piceTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Naziv ili id pogrešni!");
            } else {
                Pice newPice = new Pice(id, name);
                piceTable.update(id, newPice);
            }
        });

        panel.add(updateBtn);
    }

    private void configureGetByIdBtn() {
        getByIdBtn.setText("Prikazi Pice za uneseni ID");
        getByIdBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());
            Pice returnData = piceTable.selectById(id);
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
