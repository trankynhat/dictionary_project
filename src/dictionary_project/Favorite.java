/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary_project;

import static dictionary_project.Dictionary_Project.Anh_Viet;
import static dictionary_project.Dictionary_Project.Viet_Anh;
import static dictionary_project.Dictionary_Project.isVi_Eng;
import static dictionary_project.Dictionary_Project.path;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nhat
 */
public class Favorite extends JPanel {
    public Search search;
    String[] columnNames = {"Từ vựng", "Định nghĩa"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    String favor_voc;

    public static HashMap<String, String> Eng_favor = new HashMap<String, String>();
    public static HashMap<String, String> Viet_favor = new HashMap<String, String>();
    JTable table = new JTable(model);

    public JPanel Favorite() throws FileNotFoundException {
        CSVFile.readFile(Eng_favor, path+"\\data\\anh_favor.txt");
        CSVFile.readFile(Viet_favor, path+"\\data\\viet_favor.txt");
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(new Dimension(465, 465));
        for(var key : Eng_favor.keySet()){
            model.addRow(new Object[]{key, Eng_favor.get(key)});
        }
        for(var key : Viet_favor.keySet()){
            model.addRow(new Object[]{key, Eng_favor.get(key)});
        }
        JScrollPane scrollPane = new JScrollPane(table);
        // Thêm JScrollPane vào panel
        add(scrollPane, BorderLayout.CENTER);
        return this;
    }

    public void addFavor_voc(String favor_voc) {
        if (isVi_Eng == false) {
            if (favor_voc != null) {
                //this.Eng_favor.put(favor_voc, Anh_Viet.get(favor_voc));
                Favorite.Eng_favor.put(favor_voc, Dictionary_Project.Anh_Viet.get(favor_voc));

            }
        } else {
            if (favor_voc != null) {
                Favorite.Viet_favor.put(favor_voc, Dictionary_Project.Viet_Anh.get(favor_voc));
            }
        }

    }

    public void updateTable() {
        if (isVi_Eng != true) {

            model.setRowCount(0);

            for (HashMap.Entry<String, String> entry : Eng_favor.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                model.addRow(new Object[]{key, value});
            }
        } else {
            model.setRowCount(0);
            for (HashMap.Entry<String, String> entry : Viet_favor.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                model.addRow(new Object[]{key, value});
            }
        }
        table.setModel(model);

    }
;

}
