package Views;

import Data.Tables.FotografTable;
import Data.VjencanjeData;
import Models.Fotograf;

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

        configureElements();
    }

    private void configureElements() {
        configureInput(nameTxtFiled, "Ime");
        configureInput(surnameTxtFiled, "Prezime");
        configureInput(priceTxtFiled, "Cijena");
        configureBtn(addBtn, "Dodaj Fotografa", this::insert);
        panel.add(new JSeparator());
        configureBtn(showAllBtn, "Prikazi Fotografe", this::selectAll);
        panel.add(new JSeparator());
        configureInput(idTxtFiled, "Id");
        configureBtn(getByIdBtn, "Prikazi Fotografa za uneseni ID", this::selectById);
        configureBtn(updateBtn, "Update Fotografa za uneseni ID", this::update);
        configureBtn(deleteBtn, "Obrisi Fotografa za uneseni ID", this::delete);
    }

    private void insert() {
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
    }

    private void selectAll() {
        LinkedHashMap<Integer, Fotograf> returnData = fotografTable.selectAll();

        String output = "";

        for (int id : returnData.keySet()) {
            Fotograf temp = returnData.get(id);
            output += temp.toString() + "\n";
        }

        JOptionPane.showMessageDialog(panel, output);
    }

    private void delete() {
        int id = Integer.parseInt(idTxtFiled.getText());

        if(fotografTable.selectById(id) == null) {
            JOptionPane.showMessageDialog(panel, "Zapis ne postoji!");
        } else {
            fotografTable.delete(id);
        }
    }

    private void update() {
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
    }

    private void selectById() {
        int id = Integer.parseInt(idTxtFiled.getText());
        Fotograf returnData = fotografTable.selectById(id);
        String output = "";

        if(returnData == null) {
            output = "Pogrešan id!";
        } else {
            output = returnData.toString();
        }

        JOptionPane.showMessageDialog(panel, output);
    }
}
