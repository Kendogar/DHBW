package utilities;

import java.io.*;
import java.util.Arrays;

/**
 * Created by lars on 15.09.2015.
 */
public class FileAndFolderManagement {

    // Create new Folder
    // Path Example: "C:\\Users\\Lars\\IdeaProjects\\DHBW\\src\\io\\myDir"
    public void createFolder(String path){
        File myDir = new File(path);
        myDir.mkdir();
    }

    // Delete Folder
    public void deleteFolder(String path){
        File myDir = new File(path);
        myDir.delete();
    }

    // Create new File
    // Path Example: "C:\\Users\\Lars\\IdeaProjects\\DHBW\\src\\io\\myDir\\something.txt"
    // or "something.txt" to create in project folder
    public void createFile(String path) {
        try {

            File file = new File(path);

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Delete File
    // Path Example: "C:\\Users\\Lars\\IdeaProjects\\DHBW\\src\\io\\myDir\\something.txt"
    public void deleteFile(String path) {
        File file = new File(path);
        if (file.delete()) {
            System.out.println("File is deleted!");
        } else {
            System.out.println("File doesnt exist.");
        }
    }

    // Read File contents into String Array
    public void read(File textFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(textFile));
        int numberOfLines = 0;
        while (br.ready()){
            br.readLine();
            numberOfLines++;
        }
        br.close();
        
        String[] lines = new String[numberOfLines];
        br = new BufferedReader(new FileReader(textFile));
        for (int i = 0; i<numberOfLines;i++){
            lines[i] = br.readLine();
        }
        br.close();
        System.out.println(Arrays.toString(lines));
    }

    // Write to File
    public void write(File textFile, String[] linesToWrite) throws IOException {
        // set TRUE to append to existing text or FALSE to overwrite existing text
        BufferedWriter bw = new BufferedWriter(new FileWriter(textFile,true));
        String sep = System.lineSeparator();
        for (String blub : linesToWrite){
            bw.write(blub+sep);
        }
        bw.flush();
        bw.close();
    }

}
