package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Lars on 13.03.2015.
 */
public class JTail {
    /*int lines, bytes;
    boolean l = false;
    boolean b = false;
    String[] text;
    String dateiname;

    public JTail(String[] arguments){
        try {
            checkArgs(arguments);
        } catch (JtailIOException e) {
            e.getMessage();
        }
    }

    public void read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(dateiname)));
        int numberOfLines = 0;
        while (br.ready()){
            br.readLine();
            numberOfLines++;
        }
        br.close();
        text = new String[numberOfLines];
        br = new BufferedReader(new FileReader(new File(dateiname)));
        for (int i = 0; i<numberOfLines;i++){
            text[i] = br.readLine();
        }
        br.close();
    }

    public void checkArgs(String[] arguments) throws JtailIOException {
        switch (arguments.length){
            case 0:
                throw new JtailIOException("Keine Argumente");

            case 1:
                this.dateiname = arguments[0];
                try {
                    read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                this.dateiname = arguments[0];
                if (arguments[1].startsWith("--lines")){
                    this.lines = Integer.parseInt(arguments[1].substring(arguments[1].lastIndexOf("=")));
                    l = true;
                }
                else if (arguments[1].startsWith("--bytes")){
                    this.bytes = Integer.parseInt(arguments[1].substring(arguments[1].lastIndexOf("=")));
                    b = true;
                }
                else{
                    throw new JtailIOException("Falsche Argumente");
                }
                break;

            case 3:
                    this.dateiname = arguments[0];
                if (arguments[1].startsWith(("--lines"))){
                    this.lines = Integer.parseInt(arguments[1].substring(arguments[1].lastIndexOf("=")));
                    this.bytes = Integer.parseInt(arguments[2].substring(arguments[2].lastIndexOf("=")));
                    b = true;
                    l = true;
                }
                else {
                    this.lines = Integer.parseInt(arguments[2].substring(arguments[2].lastIndexOf("=")));
                    this.bytes = Integer.parseInt(arguments[1].substring(arguments[1].lastIndexOf("=")));
                    b = true;
                    l = true;
                }
                break;

            default:
                throw new JtailIOException("Falsche Argumente");

        }
        public void start(){

        }
    }
    }*/
}
