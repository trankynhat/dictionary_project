/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary_project;

import static dictionary_project.Dictionary_Project.isVi_Eng;
import static dictionary_project.Dictionary_Project.path;
import static dictionary_project.Dictionary_Project.resizeImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nhat
 */
public class Header extends JPanel {

    public JPanel Header() {
        setLayout(new BorderLayout());
        
        JPanel switch_panel = new JPanel();
        switch_panel.setLayout(new FlowLayout());
        ImageIcon switch_img = new ImageIcon(path+"\\image\\switch.png");
        ImageIcon switch_resize = resizeImage(switch_img, 20, 20);
        JButton switch_button = new JButton(switch_resize);

        ImageIcon switch_img_ = new ImageIcon(path+"\\image\\switch.png");
        ImageIcon switch_resize_ = resizeImage(switch_img_, 20, 20);
        JButton switch_button_ = new JButton(switch_resize_);

        //2_panel switch 
        JPanel viet_eng = new JPanel();
        JLabel viet = new JLabel("vietnamese");
        viet.setPreferredSize(new Dimension(200,30));
        viet.setHorizontalAlignment(JLabel.RIGHT);
        viet.setForeground(Color.red);
        JLabel eng = new JLabel("english");
        eng.setForeground(Color.blue);
        eng.setPreferredSize(new Dimension(200,30));
        viet_eng.add(viet);
        viet_eng.add(switch_button);
        viet_eng.add(eng);

        JPanel eng_viet = new JPanel();
        JLabel viet_ = new JLabel("vietnamese");
        
        viet_.setForeground(Color.red);
        viet_.setPreferredSize(new Dimension(200,30));
        JLabel eng_ = new JLabel("english");
        eng_.setForeground(Color.blue);
        eng_.setPreferredSize(new Dimension(200,30));
        eng_.setHorizontalAlignment(JLabel.RIGHT);
        
        eng_viet.add(eng_);
        eng_viet.add(switch_button_);
        eng_viet.add(viet_);

        add(eng_viet);

        //switch button
        switch_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isVi_Eng) { // sử dụng toán tử ! để đảo ngược giá trị của biến isVi_Eng
                    remove(eng_viet);
                    add(viet_eng);
                } else {
                    remove(viet_eng);
                    add(eng_viet);
                }
                revalidate(); // cập nhật lại giao diện của panel header
                repaint();
                isVi_Eng = !isVi_Eng;
            }
        });
        switch_button_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isVi_Eng) { // sử dụng toán tử ! để đảo ngược giá trị của biến isVi_Eng
                    remove(eng_viet);
                    add(viet_eng);
                } else {
                    remove(viet_eng);
                    add(eng_viet);
                }
                revalidate(); // cập nhật lại giao diện của panel header
                repaint();
                isVi_Eng = !isVi_Eng;
            }
        });

        return this;
    }
}
