/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary_project;

import static dictionary_project.Dictionary_Project.path;
import static dictionary_project.Favorite.Eng_favor;
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
public class History extends JPanel {

    public static HashMap<String, String> history = new HashMap<>();
    public static DefaultTableModel model;
    public static JTable his_table;

    public JPanel History() throws FileNotFoundException {
        CSVFile.readFile(history,path+"\\data\\history.txt");
        String[] columnNames = {"Word", "Time"};
        

        model = new DefaultTableModel(columnNames, 0);
        his_table = new JTable(model);
        his_table.setPreferredScrollableViewportSize(new Dimension(465, 465));
        JScrollPane scrollPane = new JScrollPane(his_table);
        
        for(var key : history.keySet()){
            model.addRow(new Object[]{key, history.get(key)});
        }
        
        
        add(scrollPane);
        
        
        return this;
    }
}
