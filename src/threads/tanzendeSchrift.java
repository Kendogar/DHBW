package threads;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lars on 16.06.2015.
 */
public class tanzendeSchrift extends JComponent implements Runnable {
    Thread runner;


    public tanzendeSchrift(){
        runner = new Thread(this);
        runner.start();

}

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

    }

    @Override
    public void paint(Graphics g) {

        g.setColor(randomColor());
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString("L", 40, 120-((int)(Math.random()*50)));
        g.setColor(randomColor());
        g.drawString("O", 60, 120-((int)(Math.random()*50)));
        g.setColor(randomColor());
        g.drawString("L", 85, 120-((int)(Math.random()*50)));
        g.setColor(randomColor());
        g.drawString("W", 105, 120-((int)(Math.random()*50)));
        g.setColor(randomColor());
        g.drawString("U", 135, 120-((int)(Math.random()*50)));
        g.setColor(randomColor());
        g.drawString("T", 160, 120-((int)(Math.random()*50)));

    }

    public Color randomColor(){
        return new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }

    public static void main(String[] args) {
        JFrame wat = new JFrame();
        wat.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wat.add(new tanzendeSchrift());
        wat.setSize(300,200);
        wat.setVisible(true);
    }
}
