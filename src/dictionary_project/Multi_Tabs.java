/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Nhat
 */
public class Multi_Tabs extends JTabbedPane {
    

    public JTabbedPane Multi_Tabs() throws FileNotFoundException {
        
        Search search = new Search();
        Favorite favorite = new Favorite();
        History history = new History();
        
        
        
        
        addTab("search", search.Search());
        addTab("favorite", favorite.Favorite());
        addTab("history", history.History());
        
        search._favor.addActionListener((ActionEvent e) -> {
            if (search.isFavor == true) {
                search.isFavor = !search.isFavor;
                search._favor.setIcon(search._favor_icon);
                if (Dictionary_Project.isVi_Eng) {
                    Favorite.Viet_favor.remove(search.input);
                } else {
                    Favorite.Eng_favor.remove(search.input);
                }
                favorite.updateTable();

            } else {
                search.isFavor = !search.isFavor;
                String temp = search.input;

                favorite.addFavor_voc(temp);
                favorite.updateTable();
                if (Dictionary_Project.isVi_Eng) {
                    Favorite.Viet_favor.put(search.input, null);
                } else {
                    Favorite.Eng_favor.put(search.input,null);
                }

                search._favor.setIcon(search.favor_icon);
                
            }

        });
//        addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                history.model.setRowCount(0);
//                for (HashMap.Entry<String, String> entry : History.history.entrySet()) {
//                    String key = entry.getKey();
//                    String value = entry.getValue();
//                    history.model.addRow(new Object[]{key, value});
//                }
//            }
//        });
//        
        return this;
    }

}
