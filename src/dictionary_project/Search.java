/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary_project;

import static dictionary_project.Dictionary_Project.Anh_Viet;
import static dictionary_project.Dictionary_Project.Viet_Anh;
import static dictionary_project.Dictionary_Project.isVi_Eng;
import static dictionary_project.Dictionary_Project.resizeImage;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Nhat
 */
public class Search extends JPanel {

    public String input;
    boolean isFavor;
    public JButton _favor = new JButton();
    ImageIcon _favor_icon = new ImageIcon(Dictionary_Project.path+"\\image\\heart_empty.png");
    ImageIcon favor_icon = new ImageIcon(Dictionary_Project.path+"\\image\\heart.png");

    public JPanel Search() {
        isFavor = false;

        Font font_input = new Font("SansSerif", Font.PLAIN, 23);

        JTextField input_txt = new JTextField();//input data field
        input_txt.setPreferredSize(new Dimension(356, 40));
        input_txt.setFont(font_input);
        input_txt.setCaretPosition(0);

        ImageIcon find_image = new ImageIcon(Dictionary_Project.path+"\\image\\find.png");
        find_image = resizeImage(find_image, 40, 40);
        JButton find_btn = new JButton();
        find_btn.setIcon(find_image);
        find_btn.setPreferredSize(new Dimension(40, 40));
        find_btn.setBackground(null);
        find_btn.setBorder(null);
        find_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Font font_output = new Font("SansSerif", Font.PLAIN, 15);
        JTextArea output_txt = new JTextArea();//output data field
        output_txt.setCaretPosition(output_txt.getDocument().getLength());
        output_txt.setLineWrap(true);
        output_txt.setWrapStyleWord(true); // thêm dòng này để đảm bảo từ không bị cắt đôi giữa hai dòng
        output_txt.setPreferredSize(new Dimension(400, 2000));
        output_txt.setFont(font_output);
        output_txt.setCaretPosition(0);
        output_txt.setEditable(false);
        output_txt.setCaretPosition(0);
        output_txt.revalidate();

        JScrollPane scrollPane_output = new JScrollPane(output_txt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_output.setPreferredSize(new Dimension(400, 350));
        scrollPane_output.getVerticalScrollBar().setValue(scrollPane_output.getVerticalScrollBar().getMaximum());
        scrollPane_output.getVerticalScrollBar().setValue(0);
        JPanel output_side = new JPanel();
        output_side.add(scrollPane_output);

        favor_icon = resizeImage(favor_icon, 30, 30);
        _favor_icon = resizeImage(_favor_icon, 30, 30);

        _favor.setIcon(_favor_icon);

        _favor.setPreferredSize(new Dimension(_favor_icon.getIconWidth(), _favor_icon.getIconHeight()));

        add(input_txt);

        add(find_btn);
        add(output_side);
        add(_favor, JButton.BORDER_PAINTED_CHANGED_PROPERTY);
        find_btn.addActionListener((e) -> {
            LocalDateTime currentTime = LocalDateTime.now();
            String input_ = input_txt.getText();
            String meaning = "";
            if (isVi_Eng) {
                meaning = Viet_Anh.get(input_);
                if (meaning == null) {
                    meaning = "Không tìm thấy từ của bạn !";

                } else {
                    if (Favorite.Viet_favor.get(input_) == null) {
                        isFavor = false;
                        _favor.setIcon(_favor_icon);
                    } else {
                        isFavor = true;
                        _favor.setIcon(favor_icon);
                    }
                    History.history.put(currentTime.toString(), input_);
                    Object[] temp = new Object[]{currentTime.toString(),input_};
                    History.model.addRow(temp);
                }
            } else {
                meaning = Anh_Viet.get(input_);
                if (meaning == null) {
                    meaning = "Not found !";
                } else {
                    if (Favorite.Eng_favor.get(input_) == null) {
                        isFavor = false;
                        _favor.setIcon(_favor_icon);
                    } else {
                        isFavor = true;
                        _favor.setIcon(favor_icon);
                    }
                    History.history.put(currentTime.toString(), input_);
                    Object[] temp = new Object[]{currentTime.toString(),input_};
                    History.model.addRow(temp);
                    
                }
            }
            input = input_;
            output_txt.setText(meaning);

        });

        return this;
    }

    public String get_favor_voc() {
//        String favor_voc = "";
//        if (isVi_Eng == false) {
//            if (Viet_Anh.get(input) != null) {
//                favor_voc = input;
//            }
//        } else {
//            if (Anh_Viet.get(input) != null) {
//                favor_voc = input;
//            }
//        }
//
//        return favor_voc;
        return input;
    }

}
