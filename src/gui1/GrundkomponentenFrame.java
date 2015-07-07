package gui1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lars on 12.05.2015.
 */
public class GrundkomponentenFrame extends JFrame {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel panel = new JPanel();
        panel.add(new JLabel("JLabel"));
        panel.add(new TextField("JTextField"));
        panel.add(new JPasswordField("Blubber"));
        panel.add(new JButton("JButton"));
        panel.add(new JToggleButton("JToggleButton"));
        panel.add(new JCheckBox("JCheckBox"));
        JRadioButton radio = new JRadioButton();
        radio.add(new JRadioButtonMenuItem("Le Item nr 1"));
        radio.add(new JRadioButtonMenuItem("Le Item nr 2"));
        panel.add(radio);
        f.add(panel);
        f.setTitle("lolwut");
        f.setSize(200, 200);
        f.setVisible(true);
    }
}
