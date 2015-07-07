package threads;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lars on 16.06.2015.
 */
public class ampel extends JComponent implements Runnable {
    int aktuellePhase = 0;
    Thread runner;
    ampelphase[] ampelz = new ampelphase[4];

    public ampel(){
        ampelz[0] = new ampelphase("grün", false, false, true, 20, 1);
        ampelz[1] = new ampelphase("gelb", false, true, false, 5, 2);
        ampelz[2] = new ampelphase("rot", true, false, false, 10, 3);
        ampelz[3] = new ampelphase("headstart", true, true, false, 5, 0);
        runner = new Thread(this);
        runner.start();
    }
    @Override
    public void run() {
        while(true){
            repaint();
            try {
                Thread.sleep(ampelz[aktuellePhase].duration * 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aktuellePhase = ampelz[aktuellePhase].next;
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(30, 30, 120, 315);
        switch (aktuellePhase){
            case 0:
                g.setColor(Color.white);
                g.fillOval(45, 35, 90, 90);
                g.fillOval(45, 140, 90, 90);
                g.setColor(Color.green);
                g.fillOval(45, 245, 90, 90);
                break;

            case 1:
                g.setColor(Color.white);
                g.fillOval(45, 35, 90, 90);
                g.setColor(Color.yellow);
                g.fillOval(45, 140, 90, 90);
                g.setColor(Color.white);
                g.fillOval(45, 245, 90, 90);
                break;
            case 2:
                g.setColor(Color.red);
                g.fillOval(45, 35, 90, 90);
                g.setColor(Color.white);
                g.fillOval(45, 140, 90, 90);
                g.fillOval(45, 245, 90, 90);
                break;
            case 3:
                g.setColor(Color.red);
                g.fillOval(45, 35, 90, 90);
                g.setColor(Color.yellow);
                g.fillOval(45, 140, 90, 90);
                g.setColor(Color.white);
                g.fillOval(45, 245, 90, 90);
                break;
        }

    }

    public static void main(String[] args) {
        JFrame ampel = new JFrame();
        ampel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ampel.setSize(300, 500);
        ampel.add(new ampel());
        ampel.setVisible(true);
    }
}
