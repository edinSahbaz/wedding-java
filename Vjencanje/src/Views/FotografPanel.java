package Views;

import Data.Tables.FotografTable;
import Data.VjencanjeData;
import Models.Fotograf;
import Models.Hrana;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class FotografPanel extends SuperPanel {
    private FotografTable fotografTable;
    private JTextField nameTxtFiled = new JTextField();
    private JTextField surnameTxtFiled = new JTextField();
    private JTextField priceTxtFiled = new JTextField();
    private JButton addBtn = new JButton();
    private JButton showAllBtn = new JButton();
    private JTextField idTxtFiled = new JTextField();
    private JButton updateBtn = new JButton();
    private JButton deleteBtn = new JButton();
    private JButton getByIdBtn = new JButton();

    public FotografPanel(VjencanjeData vjencanjeData) {
        super("Fotograf");
        this.fotografTable = vjencanjeData.getFotografTable();

        configureInput(nameTxtFiled, "Ime");
        configureInput(surnameTxtFiled, "Prezime");
        configureInput(priceTxtFiled, "Cijena");
        configureAddBtn();
        panel.add(new JSeparator());
        configureShowBtn();
        panel.add(new JSeparator());
        configureInput(idTxtFiled, "Id");
        configureGetByIdBtn();
        configureUpdateBtn();
        configureDeleteBtn();
    }

    private void configureInput(JTextField textField, String label) {
        JLabel txtFieldLabel = new JLabel();
        txtFieldLabel.setText(label);
        panel.add(txtFieldLabel);

        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setPreferredSize(new Dimension(400, 24));
        panel.add(textField);
    }

    private void configureAddBtn() {
        addBtn.setText("Dodaj Fotografa");
        addBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();
            String surname = surnameTxtFiled.getText();
            float price = Float.parseFloat(priceTxtFiled.getText());

            if(name.length() < 1 || surname.length() < 1) {
                JOptionPane.showMessageDialog(panel, "Pogrešni parametri!");
            } else {
                int id = fotografTable.getNewId();
                Fotograf newFotograf = new Fotograf(id, name, surname, price);
                fotografTable.insert(newFotograf);
            }
        });

        panel.add(addBtn);
    }

    private void configureShowBtn() {
        showAllBtn.setText("Prikazi Fotografe");
        showAllBtn.addActionListener(e -> {
            LinkedHashMap<Integer, Fotograf> returnData = fotografTable.selectAll();

            String output = "";

            for (int id : returnData.keySet()) {
                Fotograf temp = returnData.get(id);
                output += temp.toString() + "\n";
            }

            JOptionPane.showMessageDialog(panel, output);
        });

        panel.add(showAllBtn);
    }

    private void configureDeleteBtn() {
        deleteBtn.setText("Obrisi Fotografa za uneseni ID");
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());

            if(fotografTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Zapis ne postoji!");
            } else {
                fotografTable.delete(id);
            }
        });

        panel.add(deleteBtn);
    }

    private void configureUpdateBtn() {
        updateBtn.setText("Update Fotografa za uneseni ID");
        updateBtn.addActionListener(e -> {
            String name = nameTxtFiled.getText();
            String surname = surnameTxtFiled.getText();
            float price = Float.parseFloat(priceTxtFiled.getText());
            int id = Integer.parseInt(idTxtFiled.getText());

            if(name.length() < 1 || surname.length() < 1 || fotografTable.selectById(id) == null) {
                JOptionPane.showMessageDialog(panel, "Pogrešan parametar!");
            } else {
                Fotograf newFotograf = new Fotograf(id, name, surname, price);
                fotografTable.update(id, newFotograf);
            }
        });

        panel.add(updateBtn);
    }

    private void configureGetByIdBtn() {
        getByIdBtn.setText("Prikazi Fotografa za uneseni ID");
        getByIdBtn.addActionListener(e -> {
            int id = Integer.parseInt(idTxtFiled.getText());
            Fotograf returnData = fotografTable.selectById(id);
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
