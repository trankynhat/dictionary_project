/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary_project;

import static dictionary_project.Dictionary_Project.path;
import static dictionary_project.Dictionary_Project.resizeImage;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nhat
 */
public class Footer extends JPanel{
    public JPanel Footer(){
       
        //search
        ImageIcon dictionary_img = new ImageIcon(path+"\\image\\dictionary.png");
        ImageIcon dictionary_img_resize = resizeImage(dictionary_img, 50, 50);
        JLabel dictionary_label = new JLabel("Dictionary");
        JLabel dictionary_icon = new JLabel(dictionary_img_resize);
        JPanel dictionary_panel = new JPanel();
        dictionary_panel.setLayout(new BorderLayout());
        dictionary_panel.setSize(new Dimension(50, 50));
        dictionary_panel.add(dictionary_icon, BorderLayout.CENTER);
        dictionary_panel.add(dictionary_label, BorderLayout.PAGE_END);
        //FAVORITE
        ImageIcon heart = new ImageIcon(path+"\\image\\heart.png");
        ImageIcon heart_ = resizeImage(heart, 50, 50);
        JLabel favorite = new JLabel("Favorites");
        JLabel favorite_icon = new JLabel(heart_);
        JPanel favorite_panel = new JPanel();
        favorite_panel.setLayout(new BorderLayout());
        favorite_panel.setSize(new Dimension(50, 50));
        favorite_panel.add(favorite_icon, BorderLayout.CENTER);
        favorite_panel.add(favorite, BorderLayout.PAGE_END);
        //History

        ImageIcon history_img = new ImageIcon(path+"\\image\\history.png");
        ImageIcon history_resize = resizeImage(history_img, 50, 50);
        JLabel history = new JLabel("History");
        JLabel history_icon = new JLabel(history_resize);
        JPanel history_panel = new JPanel();
        history_panel.setLayout(new BorderLayout());
        history_panel.setSize(new Dimension(50, 50));
        history_panel.add(history_icon, BorderLayout.CENTER);
        history_panel.add(history, BorderLayout.PAGE_END);

        add(dictionary_panel);
        add(favorite_panel);
        add(history_panel);
        
    
    return this;
    }
}
