package dictionary_project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nhat
 */
public class Dictionary_Project {

    static String path;
    public static boolean isVi_Eng = false;

    public static HashMap<String, String> Anh_Viet;
    public static HashMap<String, String> Viet_Anh;

    public static ImageIcon resizeImage(ImageIcon img, int height, int width) {
        Image image = img.getImage();
        // transform it

        Image newimg = image.getScaledInstance(height, width, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 

        img = new ImageIcon(newimg);
        // transform it back
        return img;
    }

    public static void addComponents(Container contentPane) throws FileNotFoundException {

        Header header = new Header();
        contentPane.add(header.Header(), BorderLayout.PAGE_START);
        //Two boxs input and output translate
        Multi_Tabs multiTab = new Multi_Tabs();
        contentPane.add(multiTab.Multi_Tabs(), BorderLayout.CENTER);
        //menu
        //  Footer footer = new Footer();
        //  contentPane.add(footer.Footer(), BorderLayout.PAGE_END);
    }

    private static void createAndShowGUI() throws FileNotFoundException {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Dictionary");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        addComponents(frame.getContentPane());

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(frame,
                        "Are you sure you want to close this window?",
                        "Close Window", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        CSVFile.writeFile(Favorite.Eng_favor, path+"\\data\\anh_favor.txt");
                        CSVFile.writeFile(Favorite.Viet_favor, path+"\\data\\viet_favor.txt");
                        CSVFile.writeFile(History.history, path+"\\data\\history.txt");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Dictionary_Project.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }else{
                     frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        //Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, FileNotFoundException, URISyntaxException {
        // TODO code application logic here
        path = new File(Dictionary_Project.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile().getPath();

        String srcA_V = "..\\Dictionary_Project\\src\\Anh_Viet.xml";
        String srcV_A = "..\\Dictionary_Project\\src\\Viet_Anh.xml";
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                Dictionary_Project.createAndShowGUI();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Dictionary_Project.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Anh_Viet = XMLFile.Read(srcA_V);
        Viet_Anh = XMLFile.Read(srcV_A);

    }
}
