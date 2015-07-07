package strings;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Lars on 07.02.2015.
 */
public class Palindrom {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("String eingeben:");
        String normal = scan.nextLine();
        StringBuilder build = new StringBuilder(normal);
        String reverse = build.reverse().toString();
        System.out.println("Gedreht: " + reverse);

        if (reverse.equalsIgnoreCase(normal)){
            System.out.println("Ist Palindrom.");

            try {
                File palindfile = new File("Palindrome.txt");
                palindfile.createNewFile();
                FileWriter fw = new FileWriter(palindfile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                String sep = System.lineSeparator();
                bw.write(reverse+sep);
                bw.flush();
                bw.close();
                //System.out.println("done");
            } catch (IOException e1){
                e1.getMessage();
            }
        }
        else {
            System.out.println("Ist kein Palindrom.");
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("Palindrome.txt"));
            String sep = System.lineSeparator();
            System.out.println(sep+"Bisher gefundene Palindrome:"+sep);
            while (br.ready()) {
                String temp = br.readLine();
                System.out.println("- "+temp);
            }
            br.close();
        }
        catch (IOException e1){
            e1.printStackTrace();
        }


    }
}
