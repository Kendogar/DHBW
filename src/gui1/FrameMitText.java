package gui1;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Lars on 12.05.2015.
 */
public class FrameMitText extends JFrame{
    String title, filename;
    String text = "";
    int height, width;

    public FrameMitText(String title, String height, String width, String filename){
        this.title = title;
        this.filename = filename;
        this.height = Integer.parseInt(height);
        this.width = Integer.parseInt(width);
    }

    public void createFrame() throws IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(filename));
        while (br.ready()){
            text = text + br.readLine() + "\n";
        }
        br.close();

        JFrame f = new JFrame();
        f.add(new JScrollPane(new JTextArea(text)));
        f.setTitle(title);
        f.setSize(width, height);
        f.setVisible(true);


    }

    public static void main(String[] args) throws IOException {
        if (args.length < 4){
            System.out.println("Wrong arguments");
        }
        else {
            FrameMitText wat = new FrameMitText(args[0],args[1], args[2],args[3]);
            wat.createFrame();
        }

    }


}
