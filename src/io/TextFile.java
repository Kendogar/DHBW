package io;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Lars on 13.03.2015.
 */
public class TextFile {
    File textFile;
    String[] lines;

    public TextFile(File f) throws IOException {
        textFile = f;
        read();
    }

    public TextFile(String pathname) throws IOException {
        this(new File(pathname));
    }

    public void read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(textFile));
        int numberOfLines = 0;
        while (br.ready()){
            br.readLine();
            numberOfLines++;
        }
        br.close();
        lines = new String[numberOfLines];
        br = new BufferedReader(new FileReader(textFile));
        for (int i = 0; i<numberOfLines;i++){
            lines[i] = br.readLine();
        }
        br.close();
        /*System.out.println(Arrays.toString(lines));*/
    }

    public void write() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(textFile));
        String sep = System.lineSeparator();
        for (String blub : lines){
            bw.write(blub+sep);
        }
        bw.flush();
        bw.close();
    }

    public int availableLines(){
        return lines.length;
    }

    public String[] getLines(){
        return lines;
    }

    public String getLine(int i) throws LineNumberOutOfBoundsException {
        if (i < 1 || i > lines.length){
            throw new LineNumberOutOfBoundsException("Falscher Index, du Depp.");
        } else {
            return lines[i-1];
        }
    }

    public void setLine(int i, String s) throws LineNumberOutOfBoundsException, IOException {
        if (i < 1 || i > lines.length){
            throw new LineNumberOutOfBoundsException("Falscher Index, du Depp.");
        } else {
            lines[i-1] = s;
            this.write();
        }
    }

    public void replaceAll(String regexp, String ersatz){
        for (int i = 0; i<lines.length; i++){
            lines[i] = lines[i].replaceAll(regexp, ersatz);
        }
    }

    public void close(){
        System.out.println("File Closed");
    }

    public static void main(String[] args) throws IOException, LineNumberOutOfBoundsException {
        TextFile blub = new TextFile("RandomTextFile.txt");
        blub.write();
        blub.replaceAll("l", "p");
        //System.out.println(blub.availableLines());
        //System.out.println(Arrays.toString(blub.getLines()));
        //System.out.println(blub.getLine(1));
        //blub.setLine(1, "nana");
        blub.close();

    }
}
