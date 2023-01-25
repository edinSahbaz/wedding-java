package Views;

import Data.Tables.MaticarTable;
import Data.VjencanjeData;
import Models.Maticar;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class MaticarPanel extends SuperPanel {
    private MaticarTable maticarTable;
    private JTextField nameTxtFiled = new JTextField();
    private JTextField surnameTxtFiled = new JTextField();
    private JTextField licenceTxtFiled = new JTextField();
    private JButton addBtn = new JButton();
    private JButton showAllBtn = new JButton();
    private JTextField idTxtFiled = new JTextField();
    private JButton updateBtn = new JButton();
    private JButton deleteBtn = new JButton();
    private JButton getByIdBtn = new JButton();

    public MaticarPanel(VjencanjeData vjencanjeData) {
        super("Maticar");
        this.maticarTable = vjencanjeData.getMaticarTable();

        configureInput(nameTxtFiled, "Ime");
        configureInput(surnameTxtFiled, "Prezime");
        configureInput(licenceTxtFiled, "Broj licence");
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
        addBtn.setText("Dodaj Maticara");
        addBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();
            String surname = surnameTxtFiled.getText();
            int licence = Integer.parseInt(licenceTxtFiled.getText());

            if(name.length() < 1 || surname.length() < 1) {
                JOptionPane.showMessageDialog(panel, "Pogrešni parametri!");
            } else {
                int id = maticarTable.getNewId();
                Maticar newMaticar = new Maticar(id, name, surname, licence);
                maticarTable.insert(newMaticar);
            }
        });

        panel.add(addBtn);
    }

    private void configureShowBtn() {
        showAllBtn.setText("Prikazi Maticare");
        showAllBtn.addActionListener(e -> {
            LinkedHashMap<Integer, Maticar> returnData = maticarTable.selectAll();

            String output = "";

            for (int id : returnData.keySet()) {
                Maticar temp = returnData.get(id);
                output += temp.toString() + "\n";
            }

            JOptionPane.showMessageDialog(panel, output);
        });

        panel.add(showAllBtn);
    }

    private void configureDeleteBtn() {
        deleteBtn.setText("Obrisi Maticara za uneseni ID");
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());

            if(maticarTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Zapis ne postoji!");
            } else {
                maticarTable.delete(id);
            }
        });

        panel.add(deleteBtn);
    }

    private void configureUpdateBtn() {
        updateBtn.setText("Update Maticara za uneseni ID");
        updateBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();
            String surname = surnameTxtFiled.getText();
            int licence = Integer.parseInt(licenceTxtFiled.getText());
            int id = Integer.parseInt(idTxtFiled.getText());

            if(name.length() < 1 || surname.length() < 1 || maticarTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Pogrešan parametar!");
            } else {
                Maticar newMaticar = new Maticar(id, name, surname, licence);
                maticarTable.update(id, newMaticar);
            }
        });

        panel.add(updateBtn);
    }

    private void configureGetByIdBtn() {
        getByIdBtn.setText("Prikazi Maticara za uneseni ID");
        getByIdBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());
            Maticar returnData = maticarTable.selectById(id);
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
