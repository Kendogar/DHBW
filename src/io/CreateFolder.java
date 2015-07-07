package io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Lars on 27.02.2015.
 */
public class CreateFolder {
    public static void main(String[] args) {
        File myDir = new File("C:\\Users\\Lars\\IdeaProjects\\DHBW\\src\\io\\myDir");
        myDir.mkdir();


        File foos[] = new File[3];

        for (int i = 0; i<foos.length; i++){
            foos[i] = new File(myDir, "foo"+(i+1));
            try {
                foos[i].createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println(myDir.getPath());
        System.out.println(Arrays.toString(myDir.list()));

        for (File gnah : foos){
            gnah.delete();
        }
        myDir.delete();
    }



}
