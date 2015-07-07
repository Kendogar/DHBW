package gui1;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

/**
 * Created by Lars on 12.05.2015.
 */
public class FileChoser extends JFrame{
    public static void main(String[] args) throws IOException {
        String text = "";
        JFileChooser fc = new JFileChooser();

        int state = fc.showOpenDialog(null);

        if (state == JFileChooser.APPROVE_OPTION){
            BufferedReader br;
            br = new BufferedReader(new FileReader(fc.getSelectedFile()));
            while (br.ready()){
                text = text + br.readLine() + "\n";
            }
            br.close();

            JFrame f = new JFrame();
            f.add(new JScrollPane(new JTextArea(text)));
            f.setTitle("This is Text");
            f.setSize(500, 500);
            f.setVisible(true);
        }
    }
}

