package gui1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lars on 02.06.2015.
 */
public class Wahlergebnis extends JComponent{
    double  spd;
    double union;
    double grüne;
    double linke;
    double andere;

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 700, 400);
        g.setColor(Color.lightGray);
        g.fillRect(12, 305, 660, 60);
    }

    public Wahlergebnis(double spd, double union, double grüne, double linke, double andere){
        this.spd = spd;
        this.union = union;
        this.grüne = grüne;
        this.linke = linke;
        this.andere = andere;

        JFrame f = new JFrame();
        f.add(this);
        f.setTitle("kill me");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700,400);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Wahlergebnis alteWahl = new Wahlergebnis(33.9, 35.7, 8.4, 10.4, 7.7);
    }
}
